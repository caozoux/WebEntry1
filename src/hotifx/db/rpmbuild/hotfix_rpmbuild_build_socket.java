package hotifx.db.rpmbuild;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;


public class hotfix_rpmbuild_build_socket {
	//public static final String IP_ADDR = "11.165.67.4";  //服务器地址,这里要改成服务器的ip
	public static final String IP_ADDR = "11.238.157.159"; //服务器地址,这里要改成服务器的ip
	public static final int PORT = 50001;//服务器端口号  
	public Socket socket;
	public String logbuf;
	String kerverison;
	public String rpmlist;
	DataOutputStream outputStream;
	DataInputStream  inputStream;
	enum enumBuildState {
		BUILDLOG,
		BUILDFAIL,
		BUILDSUC,
		BUILDUKNOW
	}
	public hotfix_rpmbuild_build_socket(String kerversion) {
		logbuf="";
		this.kerverison = kerversion;
	}
	
	public String getBuildLog() {
		return this.logbuf;
	}
	public int connect() throws Exception {
    	try {
    		//创建一个流套接字并将其连接到指定主机上的指定端口号
        	socket = new Socket(IP_ADDR, PORT);
        	outputStream = new DataOutputStream(socket.getOutputStream());
        	inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream())); 
        	
    	} catch (Exception e) {
    		
    		throw new Exception();
    	}
		return 0;
	}
	public enumBuildState logBuildCmd() throws Exception {
		String jsonString = "{\"command\":\"log\"}";
		inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream())); 
		byte[] jsonByte = jsonString.getBytes();
	
		
		outputStream.write(jsonByte);
		outputStream.flush();
		System.out.println("send:"+jsonString);   
		//读取服务器端数据
		String strInputstream;
		strInputstream=inputStream.readLine();
		System.out.println("respone："+strInputstream);
		JSONObject js = JSONObject.fromObject(strInputstream);
		if (js.getString("state").equals("buildLog")) {
			this.logbuf = js.getString("log");
			return enumBuildState.BUILDLOG;
		}
		return enumBuildState.BUILDUKNOW;
	}
	
	public enumBuildState waitBuildCmd() throws Exception {
		try {
				System.out.println("waitBuildCmd start");
				String jsonString = "{\"command\":\"wait\"}";

				inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream())); 
				byte[] jsonByte = jsonString.getBytes();
        		
				outputStream.write(jsonByte);
				outputStream.flush();
				System.out.println("send :"+jsonString);

				//读取服务器端数据  
				String strInputstream;
				strInputstream=inputStream.readLine();
				System.out.println("respone："+strInputstream);
				JSONObject js = JSONObject.fromObject(strInputstream);


				if (js.getString("state").equals("buildLog")) {
					String buildlog="";
					buildlog=js.getString("log");
					System.out.println("waitBuildCmd respone：buildLog");
					return enumBuildState.BUILDLOG;
				} else if (js.getString("state").equals("buildFailed")) {					
					System.out.println("waitBuildCmd buildFailed");
					return enumBuildState.BUILDFAIL;
				} else if (js.getString("state").equals("buildSuccess")) {
					String kerlist="";
					try {
						kerlist = js.getString("rpmlist");
						if (kerlist.isEmpty())
							return enumBuildState.BUILDFAIL;
					}  catch (Exception e) { 
					
					}

					this.rpmlist = kerlist;

					System.out.println("waitBuildCmd buildSuccess");
					return enumBuildState.BUILDSUC;
				} else {
					System.out.println("waitBuildCmd unknow");
					return enumBuildState.BUILDUKNOW;
				}
							
            
		}  catch (Exception e) {
    		System.out.println("waitBuildCmd failed:" + e.getMessage()); 
    		throw new Exception();
		}
		
	}
	public int sendBuildCmd(String akid, String kerlist) throws Exception {
		try {
			
			String jsonString = "{\"command\":\"build\",\"akid\":\""+akid+"\",\"ver\":\""+kerlist+"\"}";
			JSONObject json = JSONObject.fromObject(jsonString);
			//将String转化为byte[]
        	byte[] jsonByte = new byte[jsonString.length()+1];
        	jsonByte = jsonString.getBytes();
        	
     	    outputStream.write(jsonByte);
     	    outputStream.flush();
     	    System.out.println("send:"+jsonString);
            //socket.shutdownOutput();
        
            String strInputstream;
            strInputstream=inputStream.readLine();
            JSONObject js = JSONObject.fromObject(strInputstream);
            System.out.println("respone："+js.getString("state"));
            
            if (js.getString("state") == "building") 
            	return 1;
            
		}  catch (Exception e) {
    		System.out.println("sendBuildCmd failed:" + e.getMessage()); 
    		throw new Exception();
		}
		return 0;
	}
	
	public void closed() throws IOException {
		socket.close();
	}
	
	public  int register(String name,String imgPath,int opNum){
		String imgStr = "{\"command:build\",\"ver:ali2015,ali2016\"}";//是将图片的信息转化为base64编码
		int isRegSuccess = 0;
		 while (true) {  
	        	Socket socket = null;
	        	try {
	        		//创建一个流套接字并将其连接到指定主机上的指定端口号
		        	socket = new Socket(IP_ADDR, PORT);
		        	System.out.println("连接已经建立");      
		        	//向服务器端发送数据  
		        	Map<String, String> map = new HashMap<String, String>();
		        	map.put("name",name);
		        	map.put("img",imgStr);
		        	map.put("op",opNum+"");
		        	//将json转化为String类型
		        	//JSONObject json = new JSONObject(map);
		        	JSONObject json = JSONObject.fromObject(map);

		        	String jsonString = "";
		                jsonString = json.toString();
		        	//将String转化为byte[]
		        	//byte[] jsonByte = new byte[jsonString.length()+1];
		        	byte[] jsonByte = jsonString.getBytes();
		        
		        	outputStream = new DataOutputStream(socket.getOutputStream());
		        	outputStream.write(jsonByte);
		        	outputStream.flush();
		            System.out.println("传输数据完毕");
		            socket.shutdownOutput();
		            
		            //读取服务器端数据 
		            
		            String strInputstream ="";
		            
		            strInputstream=inputStream.readUTF();
	                System.out.println("输入信息为："+strInputstream);
	                //JSONObject js = new JSONObject(strInputstream);
	                JSONObject js = JSONObject.fromObject(strInputstream);
		            System.out.println(js.get("isSuccess"));
		            isRegSuccess=Integer.parseInt((String) js.get("isSuccess")); 
		            // 如接收到 "OK" 则断开连接  
		            if (js != null) {  
		                System.out.println("客户端将关闭连接");  
		                Thread.sleep(500);  
		                break;  
		            }  
		            
	        	} catch (Exception e) {
	        		System.out.println("客户端异常:" + e.getMessage()); 
	        		break;
	        	} finally {
	        		if (socket != null) {
	        			try {
							socket.close();
						} catch (IOException e) {
							socket = null; 
							System.out.println("客户端 finally 异常:" + e.getMessage()); 
						}
	        		}
	        	}
	        }
		 return isRegSuccess;	
	}
}

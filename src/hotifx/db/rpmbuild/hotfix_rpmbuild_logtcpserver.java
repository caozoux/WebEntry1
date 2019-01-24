package hotifx.db.rpmbuild;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;

import net.sf.json.JSONObject;

public class hotfix_rpmbuild_logtcpserver extends Thread {
	public final int port = 50010;
	public ServerSocket serverSocket;
	
	static public hotfix_rpmbuild_logtcpserver mFac=null;
	static public hotfix_rpmbuild_logtcpserver getFactory() throws IOException {
		if ( mFac == null ) {
			mFac = new hotfix_rpmbuild_logtcpserver();
			mFac.serverSocket = new ServerSocket(mFac.port);
			mFac.start();
		}
		return mFac;
	}
	
	
	@Override
	public void run() {
		while (true) { 
			try {
				Socket socket = serverSocket.accept();
				System.out.println("new connecect");
				hotfix_rpmbuild_logByAkid logakid = new hotfix_rpmbuild_logByAkid(socket);
				logakid.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	class hotfix_rpmbuild_logByAkid extends Thread {
		Socket socket;
		
		hotfix_rpmbuild_logByAkid(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
	        try {
	        	hotfix_rpmbuild_server_item builditem;
				BufferedReader br = new BufferedReader(
				        new InputStreamReader(socket.getInputStream()));
		        String line = null;
		        String akid;
		        line = br.readLine();
		        JSONObject js = JSONObject.fromObject(line);
		        akid = js.getString("akid");
		        
		        if (akid.isEmpty())
		        	return;
		        
		        System.out.println(akid+" log thread start");
		        builditem = hotfix_rpmbuild_server.getServer(akid, "");
		        
		        while((line = br.readLine()) != null){
		        	builditem.buildlog.append(line+"\n");
		        }
		        
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

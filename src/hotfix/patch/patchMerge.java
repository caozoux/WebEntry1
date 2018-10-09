package hotfix.patch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.StringBuffer;

public class patchMerge {
	
    public patchMerge() {

    }
    
	public StringBuffer mergePatch(String branch, String patch)
	{
		StringBuffer output = new StringBuffer();
		String cmd="git -C /Users/zoucao-ipc/aa/gitlab/mekstone am /Users/zoucao-ipc/Downloads/0001-web-test.patch";
		Process p = null;
		
        try {
             p = Runtime.getRuntime().exec(cmd);
             p.waitFor();
             int val = p.exitValue();
            
             BufferedReader  reader;
             output.append("<b>exec cmd status:"+String.valueOf(val)+"</b>");
             output.append("<b>");
             if (val == 0) {
            	 reader=new BufferedReader(new InputStreamReader(p.getInputStream()));
            
            	 String line = "";
            	 
            	 while( (line = reader.readLine()) != null) {

            		 output.append(line + "\n");
            	 }
             } else {
              	 reader=new BufferedReader(new InputStreamReader(p.getErrorStream()));
                 
            	 String line = "";
            	 
            	 while( (line = reader.readLine()) != null) {
            		 output.append(line + "\n");
            	 }
             }
             
            
        } catch (Exception e) {
             e.printStackTrace();
             output.append("\n git failed\n");
        }
        output.append("</b>");
        
		return output;
	}
}

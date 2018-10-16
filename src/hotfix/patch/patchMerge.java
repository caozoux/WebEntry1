package hotfix.patch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.StringBuffer;

public class patchMerge {
	
	public int mStatus;
	
    public patchMerge() {
    	//default is 0, failed
    	mStatus = 0;
    }
    
    public int mergeIsPass()
    {
    	return mStatus;
    }
 
	public StringBuffer mergePatch(String kernel, String akid)
	{
		StringBuffer output = new StringBuffer();
		String cmd="/Users/zoucao-ipc/gitlab/env/hotfix/mergePatch.sh -w /Users/zoucao-ipc/gitlab/alitest/ "
				+" -k "+kernel+" -a "+akid;
			
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
            	 mStatus = 1;
             } else {
              	 reader=new BufferedReader(new InputStreamReader(p.getErrorStream()));
                 
            	 String line = "";
            	 
            	 while( (line = reader.readLine()) != null) {
            		 output.append(line + "\n");
            	 }
            	 mStatus = 0;
             }
             
            
        } catch (Exception e) {
             e.printStackTrace();
             mStatus = 0;
             output.append("\n git failed\n");
        }
        output.append("</b>");
        
		return output;
	}
}

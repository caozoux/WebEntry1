package hotfix.env;

public class hotfixEnv {

	public hotfixEnv() {
		
	}
	
	static String getGitWorkDir()
	{
		return "/Users/zoucao-ipc/gitlab/alitest";
	}
	
	static String getShellWorkDir()
	{
		return "/Users/zoucao-ipc/gitlab/env/hotfix";
	}
	
	static String getCmdFindAkId(String AkID)
	{
		return "git -C "+getGitWorkDir()+" log --all --grep Differential Revision: https://aone.alibaba-inc.com/code/"+AkID+
				" | sed -n \"1p\" | grep \"commit \"";
	}
}

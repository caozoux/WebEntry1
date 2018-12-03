package hotfix.db.rpminfo;

public class hotfix_hibernate_functionschange_bean {
	public int id;
	public String akid;
	public String file;
	public String functions;
	public String mode;
	
	public hotfix_hibernate_functionschange_bean() {}

	public hotfix_hibernate_functionschange_bean(int id, String akid, String file, String functions,String mode) {
		super();
		this.id = id;
		this.akid = akid;
		this.file = file;
		this.mode = mode;
		this.functions = functions;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAkid() {
		return this.akid;
	}
	
	public void setAkid(String akid) {
		this.akid = akid;
	}

	public String getMode() {
		return this.mode;
	}
	
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getFile() {
		return file;
	}
	
	public void setFile(String file) {
		this.file = file;
	}
	
	public String getFunctions() {
		return functions;
	}
	
	public void setFunctions(String functions) {
		this.functions = functions;
	}

}

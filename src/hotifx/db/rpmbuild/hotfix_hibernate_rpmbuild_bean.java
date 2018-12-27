package hotifx.db.rpmbuild;

public class hotfix_hibernate_rpmbuild_bean {
	int id;
	String akid;
	int status;
	String debuglog;
	String versionlist;
	String completelist;
	String currenbuild;
	int kerneltype;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAkid() {
		return akid;
	}

	public void setAkid(String akid) {
		this.akid = akid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDebuglog() {
		return debuglog;
	}

	public void setDebuglog(String debuglog) {
		this.debuglog = debuglog;
	}

	public String getVersionlist() {
		return versionlist;
	}

	public void setVersionlist(String versionlist) {
		this.versionlist = versionlist;
	}

	public String getCompletelist() {
		return completelist;
	}

	public void setCompletelist(String completelist) {
		this.completelist = completelist;
	}

	public String getCurrenbuild() {
		return currenbuild;
	}

	public void setCurrenbuild(String currenbuild) {
		this.currenbuild = currenbuild;
	}

	public int getKerneltype() {
		return kerneltype;
	}

	public void setKerneltype(int kerneltype) {
		this.kerneltype = kerneltype;
	}

	public hotfix_hibernate_rpmbuild_bean() {
		super();
		// TODO Auto-generated constructor stub
	}
}

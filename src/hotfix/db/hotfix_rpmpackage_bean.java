package hotfix.db;

public class hotfix_rpmpackage_bean {
	int id;
	String akid;
	String kernel;
	String rpmname;
	String downlink;
	String testlink;
	
	@Override
	public String toString() {
		return "hotfix_rpmpackage_bean [id=" + id + ", akid=" + akid + ", kernel=" + kernel + ", rpmname=" + rpmname
				+ ", downlink=" + downlink + ", testlink=" + testlink + "]";
	}
	public hotfix_rpmpackage_bean() {}
	public hotfix_rpmpackage_bean(int id, String akid, String kernel, String rpmname, String downlink,
			String testlink) {
		super();
		this.id = id;
		this.akid = akid;
		this.kernel = kernel;
		this.rpmname = rpmname;
		this.downlink = downlink;
		this.testlink = testlink;
	}

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

	public String getKernel() {
		return kernel;
	}

	public void setKernel(String kernel) {
		this.kernel = kernel;
	}

	public String getRpmname() {
		return rpmname;
	}

	public void setRpmname(String rpmname) {
		this.rpmname = rpmname;
	}

	public String getDownlink() {
		return downlink;
	}

	public void setDownlink(String downlink) {
		this.downlink = downlink;
	}

	public String getTestlink() {
		return testlink;
	}

	public void setTestlink(String testlink) {
		this.testlink = testlink;
	}
}

package hotfix.db.testlink;

public class hotfix_hibernate_testlink_bean {
	public int id;
	public String akid; 
	public String kerver; 
	public String testlink; 
	public int kerneltype;
	@Override
	public String toString() {
		return "hotfix_hibernate_testlink_bean [id=" + id + ", akid=" + akid + ", kerver=" + kerver + ", testlink="
				+ testlink + ", kerneltype=" + kerneltype + "]";
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
	public String getKerver() {
		return kerver;
	}
	public void setKerver(String kerver) {
		this.kerver = kerver;
	}
	public String getTestlink() {
		return testlink;
	}
	public void setTestlink(String testlink) {
		this.testlink = testlink;
	}
	public int getKerneltype() {
		return kerneltype;
	}
	public void setKerneltype(int kerneltype) {
		this.kerneltype = kerneltype;
	}
	
}

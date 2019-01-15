package hotfix.db.config;

public class hotfix_hibernate_config_bean {
	public int id;
	public String kerver;
	public String kerdesc;
	
	public hotfix_hibernate_config_bean() {
		this.id = -1;
		this.kerver = "";
		this.kerdesc = "";
	}
	
	public hotfix_hibernate_config_bean(int id, String kerver, String kerdesc) {
		super();
		this.id = id;
		this.kerver = kerver;
		this.kerdesc = kerdesc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKerver() {
		return kerver;
	}

	public void setKerver(String kerver) {
		this.kerver = kerver;
	}

	public String getKerdesc() {
		return kerdesc;
	}

	public void setKerdesc(String kerdesc) {
		this.kerdesc = kerdesc;
	}
}

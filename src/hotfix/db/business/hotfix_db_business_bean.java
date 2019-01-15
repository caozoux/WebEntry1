package hotfix.db.business;

public class hotfix_db_business_bean {
	public int id;
	public String business;
	public String busdesc;
	public hotfix_db_business_bean() {
		super();
		this.id = -1;
		this.business = "";
		this.busdesc = "";
	}
	
	public hotfix_db_business_bean(int id, String business, String desc) {
		super();
		this.id = id;
		this.business = business;
		this.busdesc = desc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getBusdesc() {
		return busdesc;
	}

	public void setBusdesc(String desc) {
		this.busdesc = desc;
	}
	
}

package hotfix.db;

import java.util.Date;

public class hitfix_rpminfo_bean {
	public int id;
	String akid;
	String link;
	String author;
	String summary;
	String description;
	String functest;
	String patchlink;
	String aonelink;
	String installleve;
	String customer;
	
	public hitfix_rpminfo_bean() {}
	
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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getFunctest() {
		return functest;
	}

	public void setFunctest(String functest) {
		this.functest = functest;
	}
	
	public String getPatchlink() {
		return patchlink;
	}

	public void setPatchlink(String patchlink) {
		this.patchlink = patchlink;
	}
	
	public String getAonelink() {
		return aonelink;
	}

	public void setAonelink(String aonelink) {
		this.aonelink = aonelink;
	}
	
	public void setInstallleve(String installleve) {
		this.installleve = installleve;
	}	
	
	public String getInstallleve() {
		return installleve;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}
	
	public String getCustomer() {
		return customer;
	}
	String targeval;
	String targ_customer;
}

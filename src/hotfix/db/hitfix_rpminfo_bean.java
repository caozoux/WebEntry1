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
	String businesslevel;
	String businessitems;
	
	public hitfix_rpminfo_bean() {
		this.businesslevel="";
		this.businessitems="";
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
	
	public void setBusinesslevel(String businesslevel) {
		this.businesslevel = businesslevel;
	}	
	
	public String getBusinesslevel() {
		return businesslevel;
	}

	public void setBusinessitems(String businessitems) {
		this.businessitems = businessitems;
	}
	
	public String getBusinessitems() {
		return businessitems;
	}
	String targeval;
	String targ_customer;
}

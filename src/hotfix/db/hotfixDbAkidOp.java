package hotfix.db;

import java.util.List;

public class hotfixDbAkidOp {
	String akid;
	String link;
	String autor;
	String description;
	String aone_link;
	// 1 通用必选， 2 通用可选， 非通用
	String mode;
	String patch_link;
	
	List<hotfixRpmInfo> RpmList;
	List<hotfixChangeFunc> funcList;
	
	
}

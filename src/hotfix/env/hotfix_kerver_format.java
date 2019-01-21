package hotfix.env;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hotfix_kerver_format {

	static public String format(String kerstr) {
		
		//check it is 3.10 or 4.9
		String res_str="";
		
		if (kerstr.indexOf("3.10") != -1) {
			System.out.println("find 3.10");
			Pattern pattern = Pattern.compile("ali.*alios7");
			Matcher matcher = pattern.matcher(kerstr);
			
			if (matcher.find())
				res_str = matcher.group().replace(".alios7", "");
		} else if (kerstr.indexOf("4.9") != -1) {
			Pattern pattern = Pattern.compile("-*.alios7.");
			Matcher matcher = pattern.matcher(kerstr);
			if (matcher.find())
				res_str = matcher.group().replace("-", "").replace(".alios7", "");
		} 
		return res_str;
	}
}

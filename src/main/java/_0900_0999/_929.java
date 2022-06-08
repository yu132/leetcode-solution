package _0900_0999;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class _929 {

	class Solution {
	    public int numUniqueEmails(String[] emails) {
	        Set<String> s=new HashSet<>();
	        
	        for(int i=0;i<emails.length;++i){
	        	
	        	String[] sp=emails[i].split(Pattern.quote("@"));
	        	
	        	String f=sp[0].replaceAll(Pattern.quote("."), "").split(Pattern.quote("+"))[0]+"@"+sp[1];
	        	
	        	s.add(f);
	        }
	        
	        return s.size();
	    }
	}
	
}

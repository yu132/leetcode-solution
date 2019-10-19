package _0900_0999;

import java.util.Arrays;

public class _937 {

	class Solution {
	    public String[] reorderLogFiles(String[] logs) {
	        Arrays.sort(logs,(f1,f2)->{
	        	
	        	int f1fi=f1.indexOf(' ')+1;
	        	
	        	char c1=f1.charAt(f1fi);
	        	
	        	boolean f1IsNum=c1>='0'&&c1<='9';
	        	
	        	int f2fi=f2.indexOf(' ')+1;
	        	
	        	char c2=f2.charAt(f2fi);
	        	
	        	boolean f2IsNum=c2>='0'&&c2<='9';
	        	
	        	if(f1IsNum){
	        		if(f2IsNum)
	        			return 0;
	        		else
	        			return 1;
	        	}else{
	        		if(f2IsNum)
	        			return -1;
		        	else{
		        		return f1.substring(f1fi).compareTo(f2.substring(f2fi));
		        	}
	        	}
	        });
	        
	        return logs;
	    }
	}
	
}

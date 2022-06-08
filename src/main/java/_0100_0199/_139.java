package _0100_0199;

import java.util.ArrayList;
import java.util.List;

public class _139 {

	class Solution {
	    public boolean wordBreak(String s, List<String> wordDict) {
	    	
	    	boolean[] flag=new boolean[s.length()+1];
	    	
	    	flag[0]=true;
	    	
	    	for(int i=1;i<=s.length();i++){
	    		for(int j=0;j<i;j++){
	    			if(flag[j]&&wordDict.contains(s.substring(j, i))){
	    				flag[i]=true;
	    				break;
	    			}
	    		}
	    	}
	    	
	    	return flag[s.length()];
	    }

	}
	
	public static void main(String[] args) {
		
		List<String> l=new ArrayList<String>();
		l.add("car");
		l.add("ca");
		l.add("rs");
		
		System.out.println(new _139().new Solution().wordBreak("cars", l));
	}
}

package _0000_0099;

import java.util.HashMap;
import java.util.Map;

public class _03 {
/* v1
	 public int lengthOfLongestSubstring(String s) {
		 int maxl=0;
		 for(int i=0;i<s.length()-maxl;i++){
			 Map<Character,Integer> count=new HashMap<>();
             boolean flag=true;
			 for(int j=0;j<s.length()-i;j++){
				Character c=s.charAt(i+j);
				Integer num=count.get(c);
				if(num==null)
					count.put(c, 1);
				else{
					if(maxl<j)
						maxl=j;
                    flag=false;
					break;
				}
			 }
			 if(flag&&maxl<s.length()-i)
				maxl=s.length()-i;
		 }
		 return maxl;
	 }*/
	
	class Solution {
	    public int lengthOfLongestSubstring(String s) {
	    	
	    	int maxL=0;
	    	
	    	int nowL=0;
	    	
	    	int nowStart=0;
	    	
	    	Map<Character,Integer> loc=new HashMap<>();
	    	
	        for(int i=0;i<s.length();i++){
	        	Integer cloc=loc.get(s.charAt(i));
	        	
	        	if(cloc==null||cloc<nowStart){//记录中没有这个字�? 或这个字符不在当前计算的字符串长度内
	        		loc.put(s.charAt(i), i);
	        		++nowL;
	        	}else{//�?
	        		if(nowL>maxL)
	        			maxL=nowL;
	        		
	        		nowStart=cloc+1;
	        		
	        		nowL=i-nowStart+1;
	        		
	        		loc.put(s.charAt(i), i);
	        	}
	        }
	        
	        if(nowL>maxL)
	        	maxL=nowL;
	        
	        return maxL;
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(new _03().new Solution().lengthOfLongestSubstring("daaaabca"));
	}
	
}

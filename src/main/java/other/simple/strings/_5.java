package other.simple.strings;

public class _5 {

	class Solution {
	    public boolean isPalindrome(String s) {
	    	s=s.toLowerCase();
	    	
	        char[] chars=s.toCharArray();
	        
	        int f=0,b=chars.length-1;
	        while(f<b){
	        	if( !( ('0'<=chars[f]&&chars[f]<='9') 
	        			||  ('a'<=chars[f]&&chars[f]<='z') ) ){
	        		f++;
	        		continue;
	        	}
	        	if( !( ('0'<=chars[b]&&chars[b]<='9') 
	        			||  ('a'<=chars[b]&&chars[b]<='z') ) ){
	        		b--;
	        		continue;
	        	}
	        	if(chars[f]!=chars[b])
	        		return false;
	        	f++;
	        	b--;
	        }
	        
	        return true;
	    }
	}
	
}

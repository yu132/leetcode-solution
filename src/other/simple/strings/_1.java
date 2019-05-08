package other.simple.strings;

public class _1 {

	class Solution {
//	    public String reverseString(String s) {
//	    	
//	        char[] chars=new char[s.length()];
//	        
//	        for(int i=0;i<s.length();i++){
//	        	chars[i]=s.charAt(s.length()-i-1);
//	        }
//	        
//	        return new String(chars);
//	    }
		public String reverseString(String s) {
	        return new StringBuilder(s).reverse().toString();
	    }
	}
	
}

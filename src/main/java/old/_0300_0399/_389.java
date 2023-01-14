package old._0300_0399;

public class _389 {
/*
	class Solution {
	    public char findTheDifference(String s, String t) {
	        char c=0;
	        
	        for(int i=0;i<s.length();i++)
	        	c^=s.charAt(i);
	        
	        for(int i=0;i<t.length();i++)
	        	c^=t.charAt(i);
	        
	        return c;
	    }
	}*/
	
	class Solution {
		public char findTheDifference(String s, String t) {
	        char[] chs=s.toCharArray();
	        char[] cht = t.toCharArray();
	        char ch = cht[0];
	        for (int i = 0; i < chs.length; i++){
	            ch ^= chs[i];
	            ch ^= cht[i+1];
	        }
	        return ch;
	    }
	}
	
}

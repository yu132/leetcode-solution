package _300_399;

public class _383 {
/* v1
	class Solution {
	    public boolean canConstruct(String ransomNote, String magazine) {
	    	
	    	if(ransomNote.length()>magazine.length())
	    		return false;
	    	
	        int[] ranCount=new int[26];
	        int[] magCount=new int[26];
	        
	        for(int i=0;i<ransomNote.length();i++)
	        	++ranCount[ransomNote.charAt(i)-'a'];
	        
	        for(int i=0;i<magazine.length();i++)
	        	++magCount[magazine.charAt(i)-'a'];
	        
	        for(int i=0;i<26;i++)
	        	if(ranCount[i]>magCount[i])
	        		return false;
	        return true;
	    }
	}*/
	
	class Solution {
	    public boolean canConstruct(String ransomNote, String magazine) {
	    	
	    	if(ransomNote.length()>magazine.length())
	    		return false;
	    	
			int[] wordCount = new int[26];
			
			for(int i=0;i<magazine.length();i++)
				++wordCount[magazine.charAt(i)-'a'];
			
			for(int i=0;i<ransomNote.length();i++)
	        	if(--wordCount[ransomNote.charAt(i)-'a']<0)
	        		return false;
			
			return true;
	    }
	}
	
}

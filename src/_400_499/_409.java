package _400_499;

public class _409 {
	
	public static void main(String[] args) {
		System.out.println('z'-'A');
	}

	class Solution {
	    public int longestPalindrome(String s) {
	        int[] charCount=new int[58];
	        
	        for(int i=0;i<s.length();i++)
	        	++charCount[s.charAt(i)-'A'];
	        
	        int has1=0;
	        
	        int count=0;
	        
	        for(int i=0;i<charCount.length;i++){
	        	if(charCount[i]%2==1){
	        		has1=1;
	        		count+=charCount[i]-1;
	        	}else
	        		count+=charCount[i];
	        }
	        
	        return count+has1;
	    }
	}
	
}

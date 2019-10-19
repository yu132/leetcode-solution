package _0100_0199;

public class _171 {

	class Solution {
	    public int titleToNumber(String s) {
	        
	    	int sum=0;
	    	
	    	for(int i=0;i<s.length();i++){
	    		int temp=s.charAt(s.length()-1-i)-'A'+1;
	    		sum+=Math.pow(26, i)*temp;
	    	}
	    	
	    	return sum;
	    	
	    }
	}
	
}

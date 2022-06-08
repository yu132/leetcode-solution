package _0100_0199;

public class _168 {

	class Solution {
	    public String convertToTitle(int n) {
	    	
	    	StringBuilder sb=new StringBuilder();
	    	
	        while(n!=0){
	        	int x=(n-1)%26;
	        	sb.append((char)('A'+x));
	        	
	        	n=(n-1)/26;
	        }
	        
	        return sb.reverse().toString();
	    }
	}
	
}

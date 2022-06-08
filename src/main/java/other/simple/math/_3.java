package other.simple.math;

public class _3 {

	class Solution {
	    public boolean isPowerOfThree(int n) {
//	        double res=Math.log10(n)/Math.log10(3);
//	        return Double.compare(res, (int)res)==0;
	    	return n>0&&1162261467%n==0;
	    }
	}
	
}

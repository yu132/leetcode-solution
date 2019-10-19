package _0100_0199;

public class _172 {

	class Solution {
	    public int trailingZeroes(int n) {
	    	int res = 0;
	        while(n!=0){
	            n /= 5;
	            res += n;
	        }
	        return res;
	    }
	}
	
}

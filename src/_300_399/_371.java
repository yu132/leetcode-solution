package _300_399;

public class _371 {

	class Solution {
	    public int getSum(int a, int b) {
	        return b!=0?getSum(a^b,(a&b)<<1):a;
	    }
	}
	
}

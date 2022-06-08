package _0300_0399;

public class _342 {

	class Solution {
	    public boolean isPowerOfFour(int num) {
	    	return ((num & (num-1)) == 0) && num > 0 && ((num  & 0x55555555) == num) ? true : false;
	    }
	}
	
}

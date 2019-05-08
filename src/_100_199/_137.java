package _100_199;

public class _137 {

	class Solution {
	    public int singleNumber(int[] nums) {
            int a=0,b=0;
            for (int c : nums) {
                b = b ^ c & ~ a;
                a = a ^ c & ~ b;
            }
            return b;
	    }
	}
	
}

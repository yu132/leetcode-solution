package redo.p1900_1999;

public class P1929 {

    class Solution {
        public int[] getConcatenation(int[] nums) {

            int n = nums.length;

            int[] ans =new int[2*n];

            System.arraycopy(nums, 0, ans, 0, n);
            System.arraycopy(nums, 0, ans, n, n);

            return ans;
        }
    }

}

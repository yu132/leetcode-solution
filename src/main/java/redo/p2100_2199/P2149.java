package redo.p2100_2199;

public class P2149 {

    class Solution {
        public int[] rearrangeArray(int[] nums) {
            int index1 = 0, index2 = 1;
            int[] ans = new int[nums.length];
            for (int num : nums) {
                if (num > 0) {
                    ans[index1] = num;
                    index1 += 2;
                } else {
                    ans[index2] = num;
                    index2 += 2;
                }
            }
            return ans;
        }
    }

}

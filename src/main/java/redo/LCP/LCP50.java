package redo.LCP;

public class LCP50 {

    class Solution {
        public int giveGem(int[] gem, int[][] operations) {
            for (int[] op : operations) {
                int count = gem[op[0]] / 2;
                gem[op[0]] -= count;
                gem[op[1]] += count;
            }
            int[] minMax = minMax(gem);
            return minMax[1] - minMax[0];
        }

        int[] minMax(int[] nums) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int num : nums) {
                max = Math.max(max, num);
                min = Math.min(min, num);
            }
            return new int[]{min, max};
        }
    }

}

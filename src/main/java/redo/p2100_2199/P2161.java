package redo.p2100_2199;

public class P2161 {

    class Solution {
        public int[] pivotArray(int[] nums, int pivot) {
            int sm = 0, eq = 0;
            for (int num : nums) {
                if (num < pivot) {
                    ++sm;
                } else if (num == pivot) {
                    ++eq;
                }
            }
            int[] ans = new int[nums.length];
            int i1 = 0, i2 = sm, i3 = sm + eq;
            for (int num : nums) {
                if (num < pivot) {
                    ans[i1++] = num;
                } else if (num == pivot) {
                    ans[i2++] = num;
                } else {
                    ans[i3++] = num;
                }
            }
            return ans;
        }
    }

}

package redo.p2000_2099;

public class P2044 {

    class Solution {

        int max = -1, count = 0;

        public int countMaxOrSubsets(int[] nums) {
            backtrack(0, 0, nums);
            return count;
        }

        void backtrack(int val, int index, int[] nums) {
            if (index == nums.length) {
                if (val > max) {
                    max = val;
                    count = 1;
                } else if (val == max) {
                    ++count;
                }
                return;
            }
            backtrack(val | nums[index], index + 1, nums);
            backtrack(val, index + 1, nums);
        }
    }

}

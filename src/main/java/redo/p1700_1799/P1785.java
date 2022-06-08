package redo.p1700_1799;

public class P1785 {

    class Solution {
        public int minElements(int[] nums, int limit, int goal) {
            long sum = sum(nums);
            long diff = Math.abs(sum - goal);
            return (int) ((diff - 1 + limit) / limit);
        }

        long sum(int[] nums) {
            long sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }
    }

}

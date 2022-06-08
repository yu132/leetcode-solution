package redo.p1900_1999;

public class P1953 {

    class Solution {
        public long numberOfWeeks(int[] milestones) {
            long max = max(milestones), sum = sum(milestones), rest = sum - max;

            if (max > rest + 1) {
                return 2 * rest + 1;
            } else {
                return sum;
            }
        }

        long sum(int[] nums) {
            long sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }

        int max(int[] nums) {
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return max;
        }
    }

}

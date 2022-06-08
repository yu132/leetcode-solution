package redo.p1800_1899;

public class P1894 {

    class Solution {
        public int chalkReplacer(int[] chalk, int k) {
            long sum = sum(chalk, 0, chalk.length);
            k %= sum;
            for (int i = 0; i < chalk.length; ++i) {
                if (k < chalk[i]) {
                    return i;
                }
                k -= chalk[i];
            }
            return -1;
        }

        long sum(int[] nums, int start, int end) {
            long sum = 0;
            for (int i = start; i < end; ++i) {
                sum += nums[i];
            }
            return sum;
        }
    }

}

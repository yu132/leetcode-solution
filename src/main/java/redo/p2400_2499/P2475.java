package redo.p2400_2499;

public class P2475 {

    class Solution {
        public int unequalTriplets(int[] nums) {
            IntFixedCounter counter = new IntFixedCounter(0, 1001);
            int total = 0;
            for (int i = 0; i < nums.length - 1; ++i) {
                for (int j = i + 1; j < nums.length; ++j) {
                    if (nums[i] != nums[j]) {
                        total += i - counter.get(nums[i]) - counter.get(nums[j]);
                    }
                }
                counter.plus1(nums[i]);
            }
            return total;
        }

        /**
         * 相当于计数数组，就是使用数组来进行计数
         * 可以计数的范围从start开始，到end-1结束
         */
        class IntFixedCounter {

            int start, arr[];

            IntFixedCounter(int start, int end) {
                this.start = start;
                arr = new int[end - start];
            }

            void plus1(int val) {
                ++arr[val - start];
            }

            void minus1(int val) {
                --arr[val - start];
            }

            void add(int val, int count) {
                arr[val - start] += count;
            }

            int get(int val) {
                if (val - start < 0 || val - start >= arr.length) {
                    return 0;
                }
                return arr[val - start];
            }
        }
    }
}

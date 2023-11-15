package redo.p2600_2699;

public class P2653 {

    class Solution {
        public int[] getSubarrayBeauty(int[] nums, int k, int x) {
            IntFixedCounter counter = new IntFixedCounter(-50, 51);
            for (int i = 0; i < k; ++i) {
                counter.plus1(nums[i]);
            }
            int countLL = 0, idx = -51;
            while (countLL < x) {
                ++idx;
                countLL += counter.get(idx);
            }
            int[] ans = new int[nums.length - k + 1];
            ans[0] = Math.min(idx, 0);
            for (int i = k; i < nums.length; ++i) {
                if (nums[i - k] <= idx) {
                    --countLL;
                }
                counter.minus1(nums[i - k]);
                if (nums[i] <= idx) {
                    ++countLL;
                }
                counter.plus1(nums[i]);
                while (countLL < x) {
                    ++idx;
                    countLL += counter.get(idx);
                }
                while (countLL - counter.get(idx) >= x) {
                    countLL -= counter.get(idx);
                    --idx;
                }
                ans[1 + i - k] = Math.min(idx, 0);
            }
            return ans;
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

package redo.p3000_3099;

import java.util.Arrays;

public class P3005 {

    class Solution {
        public int maxFrequencyElements(int[] nums) {
            IntFixedCounter counter = new IntFixedCounter(0, 101);
            for (int num : nums) {
                counter.plus1(num);
            }
            int ans = 0;
            int maxFeq = 0;
            for (int num : counter.arr) {
                if (num > maxFeq) {
                    maxFeq = num;
                    ans = maxFeq;
                } else if (num == maxFeq) {
                    ans += maxFeq;
                }
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

            boolean equals(IntFixedCounter fixedCounter) {
                return Arrays.equals(arr, arr);
            }
        }
    }

}

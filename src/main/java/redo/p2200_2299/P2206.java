package redo.p2200_2299;

public class P2206 {

    class Solution {
        public boolean divideArray(int[] nums) {
            IntFixedCounter counter = new IntFixedCounter(1, 501);
            for (int num : nums) {
                counter.plus1(num);
            }
            for (int x : counter.arr) {
                if (x % 2 != 0) {
                    return false;
                }
            }
            return true;
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

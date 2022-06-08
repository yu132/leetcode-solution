package redo.LCP;

public class LCP39 {

    class Solution {
        public int minimumSwitchingTimes(int[][] source, int[][] target) {

            IntFixedCounter counter1 = new IntFixedCounter(1, 10001);

            for (int[] a : source) {
                for (int num : a) {
                    counter1.plus1(num);
                }
            }

            for (int[] b : target) {
                for (int num : b) {
                    counter1.minus1(num);
                }
            }

            int ans = 0;

            for (int num : counter1.arr) {
                if (num > 0) {
                    ans += num;
                }
            }

            return ans;
        }

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

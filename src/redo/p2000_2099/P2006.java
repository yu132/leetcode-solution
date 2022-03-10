package redo.p2000_2099;

public class P2006 {

    class Solution {
        public int countKDifference(int[] nums, int k) {
            IntFixedCounter counter = new IntFixedCounter(1, 101);
            for (int num : nums) {
                counter.plus1(num);
            }
            int count = 0;
            for (int i = 1; i <= 100 - k; ++i) {
                count += counter.get(i) * counter.get(i + k);
            }
            return count;
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

            void add(int val, int count) {
                arr[val - start] += count;
            }

            int get(int val) {
                return arr[val - start];
            }
        }
    }

}

package redo.LCS;

import java.util.Arrays;

public class LCS02 {

    class Solution {
        public int halfQuestions(int[] questions) {
            IntFixedCounter counter = new IntFixedCounter(1, 1001);
            for (int num : questions) {
                counter.plus1(num);
            }
            Arrays.sort(counter.arr);
            int ans = 0, count = 0;
            for (int i = counter.arr.length - 1; i >= 0; --i) {
                count += counter.arr[i];
                ++ans;
                if (count >= questions.length / 2) {
                    break;
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

package redo.p3000_3099;

import java.util.Arrays;

public class P3074 {

    class Solution {
        public int minimumBoxes(int[] apple, int[] capacity) {
            int sum = 0;
            for (int num : apple) {
                sum += num;
            }
            Arrays.sort(capacity);
            for (int j = capacity.length - 1; j >= 0; --j) {
                sum -= capacity[j];
                if (sum <= 0) {
                    return capacity.length - j;
                }
            }
            return -1;
        }
    }

}

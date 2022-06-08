package redo.p1900_1999;

import java.util.function.Function;

public class P1954 {

    class Solution {
        public long minimumPerimeter(long neededApples) {
            return 8 * binarySearchMin(1, 100000, mid ->
                    2 * mid * (mid + 1) * (mid * 2 + 1) >= neededApples);
        }

        public long binarySearchMin(long low, long high, Function<Long, Boolean> judge) {
            while (low < high) {
                long mid = low + (high - low) / 2;
                if (judge.apply(mid)) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }


}

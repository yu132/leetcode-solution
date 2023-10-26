package redo.p2500_2599;

import java.util.function.Function;

public class P2594 {

    class Solution {
        public long repairCars(int[] ranks, int cars) {
            return binarySearchMin(0, 100L * cars * cars, mid -> {
                int val = 0;
                for (int rank : ranks) {
                    val += Math.sqrt((double) mid / rank);
                }
                return val >= cars;
            });
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

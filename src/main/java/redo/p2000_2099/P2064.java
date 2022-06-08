package redo.p2000_2099;

import java.util.function.Function;

public class P2064 {

    class Solution {
        public int minimizedMaximum(final int n, int[] quantities) {
            return binarySearchMin(1, 100000, maxValue -> {
                int x = 0;
                for (int quantity : quantities) {
                    x += (quantity - 1) / maxValue + 1;
                }
                return x <= n;
            });
        }

        // 寻找符合条件的最小值
        //judgeRange = [low,high-1], returnRange = [low,high]
        public int binarySearchMin(int low, int high, Function<Integer, Boolean> judge) {
            while (low < high) {
                int mid = low + (high - low) / 2;
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

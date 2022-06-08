package redo.p1800_1899;

import java.util.function.Function;

public class P1870 {

    class Solution {
        public int minSpeedOnTime(int[] dist, double hour) {
            int ans = binarySearchMin(1, (int) 1e7 + 1, mid -> {
                double time = 0;
                for (int i = 0; i < dist.length - 1; ++i) {
                    time += (dist[i] - 1) / mid + 1;
                }
                time += (double) dist[dist.length - 1] / mid;
                return time <= hour;
            });
            if (ans == (int) 1e7 + 1) {
                return -1;
            }
            return ans;
        }

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

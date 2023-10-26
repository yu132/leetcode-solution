package redo.p2500_2599;

import java.util.Arrays;
import java.util.function.Function;

public class P2517 {

    class Solution {
        public int maximumTastiness(int[] price, int k) {
            Arrays.sort(price);
            return binarySearchMax(0, price[price.length - 1], mid -> {
                int last = price[0];
                int count = 1;
                for (int i = 1; i < price.length; ++i) {
                    if (price[i] - last >= mid) {
                        ++count;
                        last = price[i];
                    }
                }
                return count >= k;
            });
        }

        // 寻找符合条件的最大值
        //judgeRange = [low,high-1], returnRange = [low-1,high-1]
        public int binarySearchMax(int low, int high, Function<Integer, Boolean> judge) {
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (judge.apply(mid)) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low - 1;
        }
    }

}

package redo.p2000_2099;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

public class P2070 {

    class Solution {
        public int[] maximumBeauty(int[][] items, int[] queries) {

            Arrays.sort(items, Comparator.comparingInt(a -> a[0]));

            int max = 0;
            for (int[] arr : items) {
                max = arr[1] = Math.max(max, arr[1]);
            }

            int[] ans = new int[queries.length];

            for (int i = 0; i < queries.length; ++i) {
                int finalI = i;
                int maxIndex = binarySearchMax(0, items.length, index -> items[index][0] <= queries[finalI]);
                if (maxIndex >= 0) {
                    ans[i] = items[maxIndex][1];
                } else {
                    ans[i] = 0;
                }
            }

            return ans;
        }

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

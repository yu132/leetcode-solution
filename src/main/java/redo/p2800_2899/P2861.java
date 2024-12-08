package redo.p2800_2899;

import java.util.List;
import java.util.function.Function;

public class P2861 {

    class Solution {
        public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
            return binarySearchMax(0, Integer.MAX_VALUE, (mid) -> {
                out:
                for (List<Integer> item : composition) {
                    long count = 0;
                    for (int i = 0; i < item.size(); ++i) {
                        count += Math.max(0, (long) item.get(i) * mid - stock.get(i)) * cost.get(i);
                        if (count > budget) {
                            continue out;
                        }
                    }
                    return true;
                }
                return false;
            });
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

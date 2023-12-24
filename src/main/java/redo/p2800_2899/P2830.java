package redo.p2800_2899;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P2830 {

    class Solution {
        public int maximizeTheProfit(int n, List<List<Integer>> offers) {
            ListMap<Integer, List<Integer>> listMap = new ListMap<>();
            for (List<Integer> offer : offers) {
                listMap.add(offer.get(1), offer);
            }
            int[] dp = new int[n + 1];
            for (int i = 0; i < n; ++i) {
                int max = dp[i];
                for (List<Integer> offer : listMap.get(i)) {
                    max = Math.max(max, dp[offer.get(0)] + offer.get(2));
                }
                dp[i + 1] = max;
            }
            return dp[n];
        }

        class ListMap<K, E> {

            Map<K, List<E>> map = new HashMap<>();

            public void add(K key, E element) {
                get(key).add(element);
            }

            public void remove(K key, E element) {
                get(key).remove(element);
            }

            public List<E> get(K key) {
                return map.computeIfAbsent(key, (x) -> new ArrayList<>());
            }

        }

    }

}

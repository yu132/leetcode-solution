package redo.p2000_2099;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P2008 {

    class Solution {
        public long maxTaxiEarnings(int n, int[][] rides) {

            ListMap<Integer, int[]> map = new ListMap<>();

            for (int[] ride : rides) {
                map.add(ride[1], ride);
            }

            long[] dp = new long[n + 1];

            for (int i = 2; i <= n; ++i) {
                dp[i] = dp[i - 1];

                for (int[] ride : map.get(i)) {
                    dp[i] = Math.max(dp[i], dp[ride[0]] + ride[2] + ride[1] - ride[0]);
                }
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

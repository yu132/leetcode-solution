package redo.p1200_1299;

import java.util.*;

public class P1235 {

    class Solution {
        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            List<Integer> position = new ArrayList<>();
            for (int i = 0; i < startTime.length; ++i) {
                position.add(startTime[i]);
                position.add(endTime[i]);
            }
            DiscretizationHelper discretizationHelper = new DiscretizationHelper(position);

            int n = discretizationHelper.n();

            int[] dp = new int[n];

            ListMap<Integer, Node> map = new ListMap<>();

            for (int i = 0; i < startTime.length; ++i) {
                map.add(discretizationHelper.get(endTime[i]), new Node(
                        discretizationHelper.get(startTime[i]), discretizationHelper.get(endTime[i]), profit[i]));
            }

            for (int i = 1; i < n; ++i) {
                dp[i] = dp[i - 1];
                for (Node node : map.get(i)) {
                    dp[i] = Math.max(dp[i], dp[node.start] + node.profit);
                }
            }

            return dp[n - 1];
        }

        class Node {
            int start, end, profit;

            public Node(int start, int end, int profit) {
                this.start = start;
                this.end = end;
                this.profit = profit;
            }
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

        //离散压缩，即将稀疏的数字序列压缩为紧凑的数字序列，不重复,离散值从0开始编号，每次+1
        class DiscretizationHelper {

            Map<Integer, Integer> map = new HashMap<>();

            public DiscretizationHelper(int[] arr) {
                Arrays.sort(arr);
                for (int num : arr) {
                    if (map.containsKey(num)) {
                        continue;
                    }
                    map.put(num, map.size());
                }
            }

            public DiscretizationHelper(List<Integer> list) {
                Collections.sort(list);
                for (int num : list) {
                    if (map.containsKey(num)) {
                        continue;
                    }
                    map.put(num, map.size());
                }
            }

            public int get(int num) {
                return map.getOrDefault(num, -1);
            }

            //离散化后的长度，去掉重复值后，和原有的数组长度不同
            public int n() {
                return map.size();
            }
        }
    }


}

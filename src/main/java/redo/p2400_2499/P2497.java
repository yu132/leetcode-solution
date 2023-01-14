package redo.p2400_2499;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P2497 {


    class Solution {
        public int maxStarSum(int[] vals, int[][] edges, int k) {
            List<Integer>[] adjac = toAdjacency(vals.length, edges);

            for (List<Integer> list : adjac) {
                list.sort(Comparator.<Integer>comparingInt(x -> vals[x]).reversed());
            }

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < vals.length; ++i) {
                max = Math.max(max, sumPrevN(adjac[i], vals, k) + vals[i]);
            }
            return max;
        }

        public int sumPrevN(List<Integer> list, int[] vals, int n) {
            int sum = 0;
            for (int i = 0; i < Math.min(list.size(), n); ++i) {
                if (vals[list.get(i)] <= 0) {
                    break;
                }
                sum += vals[list.get(i)];
            }
            return sum;
        }

        // 无向图
        List<Integer>[] toAdjacency(int n, int[][] edges) {
            @SuppressWarnings("unchecked")
            List<Integer>[] adjacency = new ArrayList[n];

            for (int i = 0; i < adjacency.length; ++i) {
                adjacency[i] = new ArrayList<>();
            }

            for (int[] edge : edges) {
                adjacency[edge[0]].add(edge[1]);
                adjacency[edge[1]].add(edge[0]);
            }

            return adjacency;
        }
    }

}

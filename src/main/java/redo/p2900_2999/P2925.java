package redo.p2900_2999;

import java.util.ArrayList;
import java.util.List;

public class P2925 {

    class Solution {
        public long maximumScoreAfterOperations(int[][] edges, int[] values) {
            List<Integer>[] adjacency = toAdjacency(values.length, edges);
            long[] ans = helper(0, -1, adjacency, values);
            return ans[0] - ans[1];
        }

        long[] helper(int node, int parent, List<Integer>[] adjacency, int[] values) {
            long[] ans = new long[2];// 0: sum, 1: cost
            long costSum = 0;
            long sum = 0;
            for (int next : adjacency[node]) {
                if (next == parent) {
                    continue;
                }
                long[] nextRet = helper(next, node, adjacency, values);
                costSum += nextRet[1];
                sum += nextRet[0];
            }
            return new long[]{sum + values[node], sum == 0 ? values[node] : Math.min(costSum, values[node])};
        }

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

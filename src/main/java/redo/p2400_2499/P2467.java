package redo.p2400_2499;

import redo.testUtil.Arrs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P2467 {

    class Solution {

        int max = Integer.MIN_VALUE;

        public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
            List<Integer>[] adjac = toAdjacency(amount.length, edges);
            int[] invalidTime = new int[amount.length];
            Arrays.fill(invalidTime, -1);
            bobTrv(bob, -1, 0, adjac, invalidTime);
            aliceTrv(0, -1, 0, 0, adjac, invalidTime, amount);
            return max;
        }

        void aliceTrv(int node, int prev, int point, int time, List<Integer>[] adjac, int[] invalidTime, int[] amount) {
            if (invalidTime[node] == -1 || invalidTime[node] > time) {
                point += amount[node];
            } else if (invalidTime[node] == time) {
                point += amount[node] / 2;
            }
            if (adjac[node].size() == 1 && node != 0) {
                max = Math.max(max, point);
                return;
            }
            for (int next : adjac[node]) {
                if (next == prev) {
                    continue;
                }
                aliceTrv(next, node, point, time + 1, adjac, invalidTime, amount);
            }
        }

        boolean bobTrv(int node, int prev, int time, List<Integer>[] adjac, int[] invalidTime) {
            if (node == 0) {
                invalidTime[node] = time;
                return true;
            }
            boolean shouldUse = false;
            for (int next : adjac[node]) {
                if (next == prev) {
                    continue;
                }
                if (bobTrv(next, node, time + 1, adjac, invalidTime)) {
                    shouldUse = true;
                    break;
                }
            }
            if (shouldUse) {
                invalidTime[node] = time;
            }
            return shouldUse;
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

    public static void main(String[] args) {
        System.out.println(new P2467().new Solution().mostProfitablePath(Arrs.build2D("[[0,2],[0,6],[1,3],[1,5],[2,5],[4,6]]"),
                6, Arrs.build("[8838,-6396,-5940,2694,-1366,4616,2966]")));
    }

}

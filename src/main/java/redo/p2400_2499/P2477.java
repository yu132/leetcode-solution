package redo.p2400_2499;

import redo.testUtil.Arrs;

import java.util.ArrayList;
import java.util.List;

public class P2477 {

    class Solution {
        public long minimumFuelCost(int[][] roads, int seats) {
            List<Integer>[] adjac = toAdjacency(100000, roads);
            return dfs(-1, 0, adjac, seats).oil;
        }

        public Node dfs(int pre, int now, List<Integer>[] adjac, int seats) {
            long oil = 0, people = 0;
            for (int next : adjac[now]) {
                if (next == pre) {
                    continue;
                }
                Node node = dfs(now, next, adjac, seats);
                people += node.people;
                oil += node.oil + (node.people - 1) / seats + 1;
            }
            return new Node(oil, people + 1);
        }

        class Node {
            long oil, people;

            public Node(long oil, long people) {
                this.oil = oil;
                this.people = people;
            }
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
        new P2477().new Solution().minimumFuelCost(Arrs.build2D("[[3,1],[3,2],[1,0],[0,4],[0,5],[4,6]]"), 2);
    }
}

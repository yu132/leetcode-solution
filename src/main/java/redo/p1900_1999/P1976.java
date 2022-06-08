package redo.p1900_1999;

import java.util.*;

public class P1976 {

    static
            //
    class Solution {

        public int countPaths(int n, int[][] roads) {
            List<Road>[] adjac = toAdjacency(n, roads);
            return (int) (dijkstraOption(n, adjac, 0, n - 1));
        }

        List<Road>[] toAdjacency(int n, int[][] edges) {
            @SuppressWarnings("unchecked")
            List<Road>[] adjacency = new ArrayList[n];

            for (int i = 0; i < adjacency.length; ++i) {
                adjacency[i] = new ArrayList<>();
            }

            for (int[] edge : edges) {
                adjacency[edge[0]].add(new Road(edge[1], edge[2]));
                adjacency[edge[1]].add(new Road(edge[0], edge[2]));
            }

            return adjacency;
        }

        public final static int MOD = 1_000_000_007;

        //不是求最短路的距离，而是求最短路的选项
        static long dijkstraOption(int n, List<Road>[] adjacencyList, int start, int end) {

            PriorityQueue<Visit> pq = new PriorityQueue<>(Comparator.comparingLong(Visit::getDistance));

            pq.offer(new Visit(0, start, n));

            Node[] nodes = new Node[n + 1];
            Arrays.setAll(nodes, x -> new Node(Long.MAX_VALUE, 0));
            nodes[n].totalOptionWithMod = 1;

            while (!pq.isEmpty()) {
                Visit visit = pq.poll();
                if (visit.distance < nodes[visit.next].minDistance) {
                    nodes[visit.next].minDistance = visit.distance;
                    nodes[visit.next].totalOptionWithMod = nodes[visit.last].totalOptionWithMod;
                } else if (visit.distance == nodes[visit.next].minDistance) {
                    nodes[visit.next].totalOptionWithMod = (nodes[visit.next].totalOptionWithMod + nodes[visit.last].totalOptionWithMod) % MOD;
                }
                if (!nodes[visit.next].visited) {
                    for (Road road : adjacencyList[visit.next]) {
                        pq.offer(new Visit(nodes[visit.next].minDistance + road.distance, road.next, visit.next));
                    }
                    nodes[visit.next].visited = true;
                }
            }

            return nodes[end].totalOptionWithMod;

        }

        static class Road {
            int next;
            long distance;

            public Road(int next, long distance) {
                this.next = next;
                this.distance = distance;
            }
        }

        static class Visit {
            long distance;
            int next;
            int last;

            public long getDistance() {
                return distance;
            }

            public Visit(long distance, int next, int last) {
                this.distance = distance;
                this.next = next;
                this.last = last;
            }
        }

        static class Node {
            long minDistance, totalOptionWithMod;
            boolean visited;

            public Node(long minDistance, long totalOptionWithMod) {
                this.minDistance = minDistance;
                this.totalOptionWithMod = totalOptionWithMod;
            }
        }

    }

}

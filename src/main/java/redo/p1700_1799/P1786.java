package redo.p1700_1799;


import java.util.*;

public class P1786 {

    class Solution {

        public final static int MOD = 1_000_000_007;

        public int countRestrictedPaths(int n, int[][] edges) {
            n = n + 1;
            List<Road>[] adjac = toAdjacencyWithDistance(n, edges);
            long[] minDis = dijkstraAllPointWithDis(n, adjac, n - 1);

            long[] dp = new long[n];
            dp[1] = 1;

            PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(node -> minDis[node.next], Comparator.reverseOrder()));
            pq.offer(new Node(0, 1));

            boolean[] visited = new boolean[n];

            while (!pq.isEmpty()) {
                Node node = pq.poll();
                dp[node.next] = (dp[node.next] + dp[node.from]) % MOD;
                if (!visited[node.next]) {
                    for (Road child : adjac[node.next]) {
                        if (minDis[child.next] < minDis[node.next]) {
                            pq.offer(new Node(node.next, child.next));
                        }
                    }
                }
                visited[node.next] = true;
            }

            return (int) (dp[n - 1] % MOD);
        }

        class Node {
            int from;
            int next;

            public Node(int from, int next) {
                this.from = from;
                this.next = next;
            }
        }

        //带距离的无向图
        List<Road>[] toAdjacencyWithDistance(int n, int[][] edges) {
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

        class Road {
            int next;
            long distance;

            public Road(int next, long distance) {
                this.next = next;
                this.distance = distance;
            }
        }

        // 对所有点进行最短路径求解
        long[] dijkstraAllPointWithDis(int n, List<Road>[] adjacencyList, int start) {
            PriorityQueue<Data2> pq = new PriorityQueue<>(Comparator.comparing(a -> a.dis));
            long[] distance = new long[n];
            Arrays.fill(distance, -1);
            distance[start] = 0;

            for (Road child : adjacencyList[start]) {
                pq.offer(new Data2(child.next, child.distance));
            }

            while (!pq.isEmpty()) {
                Data2 data = pq.poll();
                if (distance[data.next] != -1) {// 遍历过，由于dijkstra的性质，之前遍历的路线更短
                    continue;
                }
                distance[data.next] = data.dis;
                for (Road child : adjacencyList[data.next]) {
                    pq.offer(new Data2(child.next, data.dis + child.distance));
                }
            }

            return distance;
        }

        class Data2 {
            int next;
            long dis;

            public Data2(int next, long dis) {
                super();
                this.next = next;
                this.dis = dis;
            }
        }
    }

}

package redo.p2000_2099;

import java.util.*;

public class P2039 {

    class Solution {
        public int networkBecomesIdle(int[][] edges, int[] patience) {
            int n = patience.length;
            List<Integer>[] adjacencyList = toAdjacency(n, edges);
            int[] distances = dijkstraAllPoint(n, adjacencyList, 0);
            int max = 0;
            for (int i = 1; i < n; ++i) {
                int distance = distances[i];
                int clear = 4 * distance - (2 * distance - 1) % patience[i];
                max = Math.max(max, clear);
            }
            return max;
        }

        // 对所有点进行最短路径求解，邻接的两点距离为1
        int[] dijkstraAllPoint(int n, List<Integer>[] adjacencyList, int start) {
            PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dis));
            int[] distance = new int[n];
            Arrays.fill(distance, -1);
            distance[start] = 0;

            for (int child : adjacencyList[start]) {
                pq.offer(new Data(child, 1));
            }

            while (!pq.isEmpty()) {
                Data data = pq.poll();
                if (distance[data.next] != -1) {// 遍历过，由于dijkstra的性质，之前遍历的路线更短
                    continue;
                }
                distance[data.next] = data.dis;
                for (int child : adjacencyList[data.next]) {
                    pq.offer(new Data(child, data.dis + 1));
                }
            }

            return distance;
        }

        class Data {
            int next, dis;

            public Data(int next, int dis) {
                super();
                this.next = next;
                this.dis = dis;
            }
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

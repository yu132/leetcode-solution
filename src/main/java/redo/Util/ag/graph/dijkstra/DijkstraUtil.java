package redo.Util.ag.graph.dijkstra;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author 余定邦
 * @ClassName: DijkstraUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2021年1月15日
 */
public class DijkstraUtil {

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
                //组合数量很大，必须求模，对于n=300，组合的数量就会超过long的最大长度
                nodes[visit.next].totalOptionWithMod =
                        (nodes[visit.next].totalOptionWithMod + nodes[visit.last].totalOptionWithMod) % MOD;
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

    // 对所有点进行最短路径求解
    static long[] dijkstraAllPointWithDis(int n, List<Road>[] adjacencyList, int start) {
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

    static class Data2 {
        int next;
        long dis;

        public Data2(int next, long dis) {
            super();
            this.next = next;
            this.dis = dis;
        }
    }

    // 对所有点进行最短路径求解，邻接的两点距离为1
    static int[] dijkstraAllPoint(int n, List<Integer>[] adjacencyList, int start) {
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

    static class Data {
        int next, dis;

        public Data(int next, int dis) {
            super();
            this.next = next;
            this.dis = dis;
        }
    }

}

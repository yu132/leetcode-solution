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

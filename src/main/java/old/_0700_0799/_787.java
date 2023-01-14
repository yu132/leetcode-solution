package old._0700_0799;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**  
 * @ClassName: _787  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月20日  
 *  
 */
public class _787 {

    class Solution {

        class Node {
            int distince;
            int k;
            int city;

            public Node(int distince, int k, int city) {
                super();
                this.distince = distince;
                this.k        = k;
                this.city     = city;
            }
        }

        class Edge {
            int dst;
            int dis;

            public Edge(int dst, int dis) {
                super();
                this.dst = dst;
                this.dis = dis;
            }
        }

        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

            ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

            for (int i = 0; i < n; ++i) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < flights.length; ++i) {
                graph.get(flights[i][0]).add(new Edge(flights[i][1], flights[i][2]));
            }

            PriorityQueue<Node>   pq   = new PriorityQueue<>((a, b) -> {
                                           return Integer.compare(a.distince, b.distince);
                                       });

            Map<Integer, Integer> best = new HashMap<>();

            pq.offer(new Node(0, 0, src));

            while (!pq.isEmpty()) {
                Node node = pq.poll();
                if (node.k > K + 1 || node.distince > best.getOrDefault(node.k * 1000 + node.city, Integer.MAX_VALUE)) {
                    continue;
                }
                best.put(node.k * 1000 + node.city, node.distince);
                if (node.city == dst) {
                    return node.distince;
                }
                for (int i = 0; i < graph.get(node.city).size(); ++i) {
                    Edge e = graph.get(node.city).get(i);
                    pq.add(new Node(node.distince + e.dis, node.k + 1, e.dst));
                }
            }

            return -1;
        }
    }


}

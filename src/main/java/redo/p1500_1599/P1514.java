package redo.p1500_1599;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1514  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月6日  
 *  
 */
public class P1514 {

    static//

    class Solution {
        public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
            PriorityQueue<Edge> pq =
                new PriorityQueue<>((a, b) -> Double.compare(b.totalProbability, a.totalProbability));

            List<Data>[] adjacency = toAdjacency(n, edges, succProb);

            boolean[] visited = new boolean[n];

            for (Data d : adjacency[start]) {
                pq.offer(new Edge(start, d.child, d.probability));
            }

            visited[start] = true;

            while (!pq.isEmpty()) {
                Edge edge = pq.poll();
                if (edge.to == end) {
                    return edge.totalProbability;
                }
                visited[edge.to] = true;
                for (Data d : adjacency[edge.to]) {
                    if (d.child == edge.from || visited[d.child]) {
                        continue;
                    }
                    pq.offer(new Edge(edge.to, d.child, edge.totalProbability * d.probability));
                }
            }

            return 0d;
        }

        public List<Data>[] toAdjacency(int n, int[][] edges, double[] succProb) {
            @SuppressWarnings("unchecked")
            List<Data>[] adjacency = new ArrayList[n];

            for (int i = 0; i < adjacency.length; ++i) {
                adjacency[i] = new ArrayList<>();
            }

            for (int i = 0; i < edges.length; ++i) {
                adjacency[edges[i][0]].add(new Data(edges[i][1], succProb[i]));
                adjacency[edges[i][1]].add(new Data(edges[i][0], succProb[i]));
            }

            return adjacency;
        }

        static class Data {
            int child;
            double probability;

            public Data(int child, double probability) {
                super();
                this.child = child;
                this.probability = probability;
            }
        }

        static class Edge {
            int from;
            int to;
            double totalProbability;

            public Edge(int from, int to, double totalProbability) {
                super();
                this.from = from;
                this.to = to;
                this.totalProbability = totalProbability;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(0.25,
            s.maxProbability(3, Arrs.build2D("[[0,1],[1,2],[0,2]]"), new double[] {0.5, 0.5, 0.2}, 0, 2), 0.00001);

        Assert.assertEquals(0.3,
            s.maxProbability(3, Arrs.build2D("[[0,1],[1,2],[0,2]]"), new double[] {0.5, 0.5, 0.3}, 0, 2), 0.00001);

        Assert.assertEquals(0d, s.maxProbability(3, Arrs.build2D("[[0,1]]"), new double[] {0.5}, 0, 2), 0.00001);

    }

}

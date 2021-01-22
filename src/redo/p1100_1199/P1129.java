package redo.p1100_1199;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1129  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月15日  
 *  
 */
public class P1129 {

    static//

    class Solution {
        public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
            List<Integer>[] adjacencyRed = toOrderlyAdjacency(n, red_edges),
                adjacencyBlue = toOrderlyAdjacency(n, blue_edges);

            int[] ans = dijkstraAllPoint(n, adjacencyRed, adjacencyBlue, 0);

            for (int i = 0; i < n; ++i) {
                if (ans[i] == Integer.MAX_VALUE) {
                    ans[i] = -1;
                }
            }

            return ans;
        }

        static int[] dijkstraAllPoint(int n, List<Integer>[] adjacencyListRed, List<Integer>[] adjacencyListBlue,
            int start) {
            PriorityQueue<Data> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dis, b.dis));
            int[] distance = new int[n];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[start] = 0;

            boolean[] usedRed = new boolean[n], usedBlue = new boolean[n];

            for (int child : adjacencyListRed[start]) {
                pq.offer(new Data(child, 1, true));
            }
            for (int child : adjacencyListBlue[start]) {
                pq.offer(new Data(child, 1, false));
            }

            while (!pq.isEmpty()) {
                Data data = pq.poll();
                if (data.red) {
                    if (usedRed[data.next]) {
                        continue;
                    }
                    usedRed[data.next] = true;
                } else {
                    if (usedBlue[data.next]) {
                        continue;
                    }
                    usedBlue[data.next] = true;
                }
                distance[data.next] = Math.min(distance[data.next], data.dis);
                if (data.red) {
                    for (int child : adjacencyListBlue[data.next]) {
                        pq.offer(new Data(child, data.dis + 1, false));
                    }
                } else {
                    for (int child : adjacencyListRed[data.next]) {
                        pq.offer(new Data(child, data.dis + 1, true));
                    }
                }
            }

            return distance;
        }

        static class Data {
            int next, dis;
            boolean red;

            public Data(int next, int dis, boolean red) {
                super();
                this.next = next;
                this.dis = dis;
                this.red = red;
            }
        }

        // 有向图
        public List<Integer>[] toOrderlyAdjacency(int n, int[][] edges) {
            @SuppressWarnings("unchecked")
            List<Integer>[] adjacency = new ArrayList[n];

            for (int i = 0; i < adjacency.length; ++i) {
                adjacency[i] = new ArrayList<>();
            }

            for (int[] edge : edges) {
                adjacency[edge[0]].add(edge[1]);
            }

            return adjacency;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {0, 1, -1},
            s.shortestAlternatingPaths(3, Arrs.build2D("[[0,1],[1,2]]"), Arrs.build2D("[]")));

        Assert.assertArrayEquals(new int[] {0, 1, -1},
            s.shortestAlternatingPaths(3, Arrs.build2D("[[0,1]]"), Arrs.build2D("[[2,1]]")));

        Assert.assertArrayEquals(new int[] {0, -1, -1},
            s.shortestAlternatingPaths(3, Arrs.build2D("[[1,0]]"), Arrs.build2D("[[2,1]]")));

        Assert.assertArrayEquals(new int[] {0, 1, 2},
            s.shortestAlternatingPaths(3, Arrs.build2D("[[0,1]]"), Arrs.build2D("[[1,2]]")));

        Assert.assertArrayEquals(new int[] {0, 1, 1},
            s.shortestAlternatingPaths(3, Arrs.build2D("[[0,1],[0,2]]"), Arrs.build2D("[[1,0]]")));

        Assert.assertArrayEquals(new int[] {0, 1, 2, 3, 7}, s.shortestAlternatingPaths(5,
            Arrs.build2D("[[0,1],[1,2],[2,3],[3,4]]"), Arrs.build2D("[[1,2],[2,3],[3,1]]")));
    }

}

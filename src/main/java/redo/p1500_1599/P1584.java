package redo.p1500_1599;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1584  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月3日  
 *  
 */
public class P1584 {

    static//

    class Solution {
        public int minCostConnectPoints(int[][] points) {
            PriorityQueue<Data> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dis, b.dis));
            for (int i = 0; i < points.length; ++i) {
                for (int j = i + 1; j < points.length; ++j) {
                    pq.offer(
                        new Data(Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]), i, j));
                }
            }

            WeightedUnionFind uf = new WeightedUnionFind(points.length);

            int dis = 0;

            while (uf.connectedComponentCount() > 1) {
                Data data = pq.poll();
                if (uf.isConnected(data.point1, data.point2)) {
                    continue;
                }
                uf.union(data.point1, data.point2);
                dis += data.dis;
            }

            return dis;
        }

        static class Data {
            int dis, point1, point2;

            public Data(int dis, int point1, int point2) {
                super();
                this.dis = dis;
                this.point1 = point1;
                this.point2 = point2;
            }
        }

        public static class WeightedUnionFind {
            private int[] weight;
            private int[] parent;
            private int connectedComponentCount;

            public WeightedUnionFind(int num) {
                super();
                weight = new int[num];
                Arrays.fill(weight, 1);
                parent = new int[num];
                Arrays.setAll(parent, (x) -> x);
                connectedComponentCount = num;
            }

            public void union(int x, int y) {
                int typeX = find(x), typeY = find(y);
                if (typeX == typeY) {
                    return;
                }
                if (weight[typeX] >= weight[typeY]) {
                    parent[typeY] = typeX;
                    weight[typeX] += weight[typeY];
                } else {
                    parent[typeX] = y;
                    weight[typeY] += weight[typeX];
                }
                --connectedComponentCount;
            }

            public int find(int x) {
                return parent[x] == x ? x : (x = find(parent[x]));
            }

            public boolean isConnected(int x, int y) {
                return find(x) == find(y);
            }

            public int connectedComponentCount() {
                return connectedComponentCount;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(20, s.minCostConnectPoints(Arrs.build2D("[[0,0],[2,2],[3,10],[5,2],[7,0]]")));
        Assert.assertEquals(18, s.minCostConnectPoints(Arrs.build2D("[[3,12],[-2,5],[-4,1]]")));
        Assert.assertEquals(4, s.minCostConnectPoints(Arrs.build2D("[[0,0],[1,1],[1,0],[-1,1]]")));
        Assert.assertEquals(4000000, s.minCostConnectPoints(Arrs.build2D("[[-1000000,-1000000],[1000000,1000000]]")));
        Assert.assertEquals(0, s.minCostConnectPoints(Arrs.build2D("[[0,0]]")));

    }

}

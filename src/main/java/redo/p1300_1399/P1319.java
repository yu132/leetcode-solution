package redo.p1300_1399;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1319  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月10日  
 *  
 */
public class P1319 {

    static//

    class Solution {
        public int makeConnected(int n, int[][] connections) {
            if (connections.length < n - 1) {
                return -1;
            }
            RankedUnionFind uf = new RankedUnionFind(n);
            for (int[] connection : connections) {
                uf.union(connection[0], connection[1]);
            }
            return uf.connectedComponentCount - 1;
        }

        public static class RankedUnionFind {
            int connectedComponentCount, rank[], parent[];

            public RankedUnionFind(int num) {
                super();
                rank = new int[num];
                Arrays.fill(rank, 1);
                parent = new int[num];
                Arrays.setAll(parent, (x) -> x);
                connectedComponentCount = num;
            }

            public void union(int x, int y) {
                int typeX = find(x), typeY = find(y);
                if (typeX == typeY) {
                    return;
                }
                if (rank[typeX] > rank[typeY]) {
                    parent[typeY] = typeX;
                } else if (rank[typeX] < rank[typeY]) {
                    parent[typeX] = y;
                } else {
                    parent[typeY] = typeX;
                    rank[typeX] += 1;
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
        Assert.assertEquals(1, s.makeConnected(4, Arrs.build2D("[[0,1],[0,2],[1,2]]")));
        Assert.assertEquals(2, s.makeConnected(6, Arrs.build2D("[[0,1],[0,2],[0,3],[1,2],[1,3]]")));
        Assert.assertEquals(-1, s.makeConnected(6, Arrs.build2D("[[0,1],[0,2],[0,3],[1,2]]")));
        Assert.assertEquals(0, s.makeConnected(5, Arrs.build2D("[[0,1],[0,2],[3,4],[2,3]]")));
    }

}

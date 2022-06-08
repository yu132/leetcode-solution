package redo.p0900_0999;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P947  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月22日  
 *  
 */
public class P947 {

    static//

    class Solution {
        public int removeStones(int[][] stones) {

            RankedUnionFind uf = new RankedUnionFind(stones.length);

            int[][] stonesAndIndex = new int[stones.length][3];
            for (int i = 0; i < stones.length; ++i) {
                stonesAndIndex[i][0] = stones[i][0];
                stonesAndIndex[i][1] = stones[i][1];
                stonesAndIndex[i][2] = i;
            }
            Arrays.sort(stonesAndIndex, (a, b) -> Integer.compare(a[0], b[0]));

            for (int i = 1; i < stonesAndIndex.length; ++i) {
                if (stonesAndIndex[i - 1][0] == stonesAndIndex[i][0]) {
                    uf.union(stonesAndIndex[i - 1][2], stonesAndIndex[i][2]);
                }
            }

            Arrays.sort(stonesAndIndex, (a, b) -> Integer.compare(a[1], b[1]));

            for (int i = 1; i < stonesAndIndex.length; ++i) {
                if (stonesAndIndex[i - 1][1] == stonesAndIndex[i][1]) {
                    uf.union(stonesAndIndex[i - 1][2], stonesAndIndex[i][2]);
                }
            }

            return stones.length - uf.connectedComponentCount();
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
        Assert.assertEquals(5, s.removeStones(Arrs.build2D("[[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]")));
        Assert.assertEquals(3, s.removeStones(Arrs.build2D("[[0,0],[0,2],[1,1],[2,0],[2,2]]")));
        Assert.assertEquals(0, s.removeStones(Arrs.build2D("[[0,0]]")));
    }

}

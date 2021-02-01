package redo.p0800_0899;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.Arrs;

/**  
 * @ClassName: P996  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月26日  
 *  
 */
public class P886 {

    static//

    class Solution {
        public boolean possibleBipartition(int N, int[][] dislikes) {
            RankedUnionFind uf = new RankedUnionFind(2 * N + 1);
            for (int[] dislike : dislikes) {
                int i = uf.find(dislike[0]);
                int he = uf.find(dislike[1]);
                int iDisLike = uf.find(dislike[0] + N);
                int heDisLike = uf.find(dislike[1] + N);
                if (i == he) {
                    return false;
                }
                uf.union(i, heDisLike);
                uf.union(he, iDisLike);
            }
            return true;
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
        Assert.assertEquals(true, s.possibleBipartition(4, Arrs.build2D("[[1,2],[1,3],[2,4]]")));
        Assert.assertEquals(false, s.possibleBipartition(3, Arrs.build2D("[[1,2],[1,3],[2,3]]")));
        Assert.assertEquals(false, s.possibleBipartition(5, Arrs.build2D("[[1,2],[2,3],[3,4],[4,5],[1,5]]")));
    }

}

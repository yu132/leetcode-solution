package redo.p0900_0999;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P990  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月20日  
 *  
 */
public class P990 {

    static//

    class Solution {
        public boolean equationsPossible(String[] equations) {
            RankedUnionFind uf = new RankedUnionFind(26);
            List<Pair> notEqual = new ArrayList<>();
            for (String equation : equations) {
                int a = equation.charAt(0) - 'a', b = equation.charAt(3) - 'a';
                if (equation.charAt(1) == '!') {
                    notEqual.add(new Pair(a, b));
                } else {
                    uf.union(a, b);
                }
            }
            for (Pair pair : notEqual) {
                if (uf.isConnected(pair.a, pair.b)) {
                    return false;
                }
            }
            return true;
        }

        static class Pair {
            int a, b;

            public Pair(int a, int b) {
                super();
                this.a = a;
                this.b = b;
            }
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
        Assert.assertEquals(false, s.equationsPossible(new String[] {"a==b", "b!=a"}));
        Assert.assertEquals(true, s.equationsPossible(new String[] {"b==a", "a==b"}));
        Assert.assertEquals(true, s.equationsPossible(new String[] {"a==b", "b==c", "a==c"}));
        Assert.assertEquals(false, s.equationsPossible(new String[] {"a==b", "b!=c", "c==a"}));
        Assert.assertEquals(true, s.equationsPossible(new String[] {"c==c", "b==d", "x!=z"}));
    }

}

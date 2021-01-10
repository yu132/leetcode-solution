package redo.p1300_1399;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1361  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月9日  
 *  
 */
public class P1361 {

    static//

    class Solution {
        public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
            int[] in = new int[n], out = new int[n];
            int count = 0;

            WeightedUnionFind uf = new WeightedUnionFind(n);

            count += count(leftChild, in, out, uf);
            count += count(rightChild, in, out, uf);

            // 边数不为n-1，就不是树，联通分支大于1也不是树
            if (count != n - 1 || uf.connectedComponentCount != 1) {
                return false;
            }

            boolean hasIn0 = false;
            for (int i = 0; i < n; ++i) {
                if (in[i] == 0) {
                    if (hasIn0) {// 不能有两个根节点
                        return false;
                    }
                    hasIn0 = true;
                } else if (in[i] >= 2) {// 不是二叉树，因为一个节点最多只有一个父节点
                    return false;
                } else if (out[i] >= 3) {// 三叉树以上
                    return false;
                }
            }
            return true;
        }

        private int count(int[] child, int[] in, int[] out, WeightedUnionFind uf) {
            int count = 0;
            for (int i = 0; i < child.length; ++i) {
                if (child[i] == -1) {
                    continue;
                }
                ++out[i];
                ++in[child[i]];
                ++count;
                uf.union(i, child[i]);
            }
            return count;
        }

        public static class WeightedUnionFind {
            int connectedComponentCount, weight[], parent[];

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
        Assert.assertEquals(true, s.validateBinaryTreeNodes(4, new int[] {1, -1, 3, -1}, new int[] {2, -1, -1, -1}));
        Assert.assertEquals(false, s.validateBinaryTreeNodes(4, new int[] {1, -1, 3, -1}, new int[] {2, 3, -1, -1}));
        Assert.assertEquals(false, s.validateBinaryTreeNodes(2, new int[] {1, 0}, new int[] {-1, -1}));
        Assert.assertEquals(false,
            s.validateBinaryTreeNodes(6, new int[] {1, -1, -1, 4, -1, -1}, new int[] {2, -1, -1, 5, -1, -1}));

        Assert.assertEquals(false, s.validateBinaryTreeNodes(4, new int[] {1, 0, 3, -1}, new int[] {-1, -1, -1, -1}));

    }

}

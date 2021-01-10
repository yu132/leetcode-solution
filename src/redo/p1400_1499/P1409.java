package redo.p1400_1499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1409  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月9日  
 *  
 */
public class P1409 {

    static//

    class Solution {
        public int[] processQueries(int[] queries, int m) {
            int n = queries.length;
            BinaryIndexedTree bit = new BinaryIndexedTree(n + m);

            int[] pos = new int[m + 1], ans = new int[n];

            for (int i = 1; i <= m; ++i) {
                pos[i] = n + i - 1;
                bit.add(n + i - 1, 1);
            }

            for (int i = 0; i < n; ++i) {
                ans[i] = bit.getSum(pos[queries[i]]);
                bit.add(pos[queries[i]], -1);
                pos[queries[i]] = n - i - 1;
                bit.add(pos[queries[i]], 1);
            }

            return ans;
        }

        static class BinaryIndexedTree {
            // private int[] a;//真实的数组情况

            private int[] c;// 对应的树状数组

            public int size() {
                return c.length - 1;
            }

            public BinaryIndexedTree(int length) {
                // a = new int[length];
                c = new int[length + 1];// 0处不使用，所以需要多一位的长度
            }

            // 设置index位置上的值为num
            // public void set(int index, int num) {
            // for (int i = index + 1; i < c.length; i += lowbit(i)) {
            // c[i] += num - a[index];
            // }
            // a[index] = num;
            // }

            // 让index位置上的值加上这个值
            public void add(int index, int num) {
                for (int i = index + 1; i < c.length; i += lowbit(i))
                    c[i] += num;
                // a[index] += num;
            }

            // 返回0-index(不包括)的区间和
            public int getSum(int index) {
                int sum = 0;

                // 由于index对应数组index+1的位置，从index开始加正好不包括index+1位置上的值
                for (int i = index; i > 0; i -= lowbit(i))
                    sum += c[i];

                return sum;
            }

            // 返回0-index(包括)的区间和
            public int getSumInclude(int index) {
                int sum = 0;

                // 由于index对应数组index+1的位置，从index开始加正好不包括index+1位置上的值
                for (int i = index + 1; i > 0; i -= lowbit(i))
                    sum += c[i];

                return sum;
            }

            // 不包括to
            public int getSumRange(int indexFrom, int indexTo) {
                return getSum(indexTo) - getSum(indexFrom);
            }

            // 包括to
            public int getSumRangeInclude(int indexFrom, int indexTo) {
                return getSumInclude(indexTo) - getSum(indexFrom);
            }

            int lowbit(int x) {
                return x & -x;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {2, 1, 2, 1}, s.processQueries(new int[] {3, 1, 2, 1}, 5));
        Assert.assertArrayEquals(new int[] {3, 1, 2, 0}, s.processQueries(new int[] {4, 1, 2, 2}, 4));
        Assert.assertArrayEquals(new int[] {6, 5, 0, 7, 5}, s.processQueries(new int[] {7, 5, 5, 8, 3}, 8));
    }

}

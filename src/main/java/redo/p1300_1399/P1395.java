package redo.p1300_1399;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1395  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月9日  
 *  
 */
public class P1395 {

    static//

    class Solution {
        public int numTeams(int[] rating) {
            discretizeInplace(rating);

            BinaryIndexedTree bitLeft = new BinaryIndexedTree(rating.length),
                bitRight = new BinaryIndexedTree(rating.length);

            for (int i = 0; i < rating.length; ++i) {
                bitRight.add(rating[i], 1);
            }

            int ans = 0;
            for (int j = 0; j < rating.length; ++j) {
                bitRight.add(rating[j], -1);
                int leftLower = bitLeft.getSum(rating[j]),
                    leftGreater = bitLeft.getSumRange(rating[j] + 1, rating.length),
                    rightLower = bitRight.getSum(rating[j]),
                    rightGreater = bitRight.getSumRange(rating[j] + 1, rating.length);
                ans += leftLower * rightGreater + rightLower * leftGreater;
                bitLeft.add(rating[j], 1);
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

            // 单点赋值，设置index位置上的值为num
            // public void set(int index, int num) {
            // for (int i = index + 1; i < c.length; i += lowbit(i)) {
            // c[i] += num - a[index];
            // }
            // a[index] = num;
            // }

            // 单点更新，让index位置上的值加上这个值
            public void add(int index, int num) {
                for (int i = index + 1; i < c.length; i += lowbit(i)) {
                    c[i] += num;
                }
                // a[index] += num;
            }

            // 返回0-index(不包括)的区间和
            public int getSum(int index) {
                int sum = 0;

                // 由于index对应数组index+1的位置，从index开始加正好不包括index+1位置上的值
                for (int i = index; i > 0; i -= lowbit(i)) {
                    sum += c[i];
                }

                return sum;
            }

            // 返回0-index(包括)的区间和
            public int getSumInclude(int index) {
                int sum = 0;

                // 由于index对应数组index+1的位置，从index开始加正好不包括index+1位置上的值
                for (int i = index + 1; i > 0; i -= lowbit(i)) {
                    sum += c[i];
                }

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

        private static class Node {
            int val;
            int id;

            public Node(int val, int id) {
                super();
                this.val = val;
                this.id = id;
            }
        }

        public static void discretizeInplace(int[] array) {

            Node[] nodes = new Node[array.length];

            Arrays.setAll(nodes, (i) -> new Node(array[i], i));

            Arrays.sort(nodes, (a, b) -> Integer.compare(a.val, b.val));

            for (int i = 0; i < array.length; ++i) {
                array[nodes[i].id] = i;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.numTeams(new int[] {2, 5, 3, 4, 1}));
        Assert.assertEquals(3, s.numTeams(new int[] {2, 5, 3, 4, 1}));
        Assert.assertEquals(0, s.numTeams(new int[] {2, 1, 3}));
        Assert.assertEquals(4, s.numTeams(new int[] {1, 2, 3, 4}));
        Assert.assertEquals(3, s.numTeams(new int[] {3, 6, 7, 5, 1}));
        Assert.assertEquals(1, s.numTeams(new int[] {1, 2, 3}));
    }

}

package redo.p0300_0399;

/**  
 * @ClassName: P307  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月14日  
 *  
 */
public class P307 {

    static//

    class NumArray {

        BinaryIndexedTree bit;

        public NumArray(int[] nums) {
            bit = new BinaryIndexedTree(nums.length);
            for (int i = 0; i < nums.length; ++i) {
                bit.set(i, nums[i]);
            }
        }

        public void update(int index, int val) {
            bit.set(index, val);
        }

        public int sumRange(int left, int right) {
            return bit.getSumRangeInclude(left, right);
        }


        public static class BinaryIndexedTree {
            private int[] a;// 真实的数组情况

            private int[] c;// 对应的树状数组

            public int size() {
                return c.length - 1;
            }

            // length是树状数组的长度，即只能存储0到length-1长的值，如果取值区间为0到length，那么要+1
            public BinaryIndexedTree(int length) {
                a = new int[length];
                c = new int[length + 1];// 0处不使用，所以需要多一位的长度
            }

            // 单点赋值，设置index位置上的值为num
            public void set(int index, int num) {
                for (int i = index + 1; i < c.length; i += lowbit(i)) {
                    c[i] += num - a[index];
                }
                a[index] = num;
            }

            // 单点更新，让index位置上的值加上这个值
            public void add(int index, int num) {
                for (int i = index + 1; i < c.length; i += lowbit(i)) {
                    c[i] += num;
                }
                a[index] += num;
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
    }

}

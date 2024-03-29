/**
 * @Title: _307.java
 *
 * @Package old._0300_0399
 *
 * @Description: TODO(用一句话描述该文件做什么)
 *
 * @author 余定邦
 *
 * @date 2020年1月31日
 *
 */
package old._0300_0399;

/**
 * @ClassName: _307
 *
 * @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author 余定邦
 *
 * @date 2020年1月31日
 * 
 */
public class _307 {

    class NumArray {

        public class IntBinaryIndexedTreeForSum {

            int lowbit(int x) {
                return x & -x;
            }

            private int[] a;// 真实的数组情况

            private int[] c;// 对应的树状数组

            public int size() {
                return c.length - 1;
            }

            public IntBinaryIndexedTreeForSum(int length) {
                a = new int[length];
                c = new int[length + 1];// 0处不使用，所以需要多一位的长度
            }

            /**
             * 单点赋值
             *
             * 不要单点赋值的话就可以不要数组a
             *
             * @param index
             *            为了保持习惯，依然当作0开始，但实际上修改的是数组中的index+1位置
             * @param num
             *            设置index位置上的值
             */
            public void set(int index, int num) {
                for (int i = index + 1; i < c.length; i += lowbit(i))
                    c[i] += num - a[index];
                a[index] = num;
            }

            /**
             * 单点更新
             * 
             * @param index
             *            为了保持习惯，依然当作0开始，但实际上修改的是数组中的index+1位置
             * @param num
             *            让index位置上的值加上这个值
             */
            public void update(int index, int num) {
                for (int i = index + 1; i < c.length; i += lowbit(i))
                    c[i] += num;
                a[index] += num;
            }

            /**
             * 区间查询
             * 
             * @param index
             *            为了习惯，写成了不包含这个位置的格式
             * @return 返回0-index(不包括)的区间和
             */
            public int getSum(int index) {
                int sum = 0;

                // 由于index对应数组index+1的位置，从index开始加正好不包括index+1位置上的值
                for (int i = index; i > 0; i -= lowbit(i))
                    sum += c[i];

                return sum;
            }

            /**
             * 区间查询
             * 
             * @param index
             * @return 返回0-index(包括)的区间和
             */
            public int getSumInclude(int index) {
                int sum = 0;

                // 由于index对应数组index+1的位置，从index开始加正好不包括index+1位置上的值
                for (int i = index + 1; i > 0; i -= lowbit(i))
                    sum += c[i];

                return sum;
            }

            /**
             * 区间查询
             * 
             * @param indexFrom
             *            区间的开始索引
             * @param indexTo
             *            区间的结束索引（不包括）
             * @return 区间和
             */
            public int getSumRange(int indexFrom, int indexTo) {
                return getSum(indexTo) - getSum(indexFrom);
            }

            /**
             * 区间查询
             * 
             * @param indexFrom
             *            区间的开始索引
             * @param indexTo
             *            区间的结束索引（包括）
             * @return 区间和
             */
            public int getSumRangeInclude(int indexFrom, int indexTo) {
                return getSumInclude(indexTo) - getSum(indexFrom);
            }

        }

        private IntBinaryIndexedTreeForSum indexTree;


        public NumArray(int[] nums) {
            indexTree = new IntBinaryIndexedTreeForSum(nums.length);
            for (int i = 0; i < nums.length; ++i) {
                indexTree.update(i, nums[i]);
            }
        }

        public void update(int i, int val) {
            indexTree.set(i, val);
        }

        public int sumRange(int i, int j) {
            return indexTree.getSumRangeInclude(i, j);
        }
    }



}

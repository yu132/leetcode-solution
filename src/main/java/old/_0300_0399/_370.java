package old._0300_0399;

/**  
 * @ClassName: _370  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月12日  
 *  
 */
public class _370 {

    class Solution {
        public class IntBinaryIndexedTreeForSum2 {

            int lowbit(int x) {
                return x & -x;
            }

            private int[] sum;// 对应的树状数组

            public int size() {
                return sum.length - 1;
            }

            public IntBinaryIndexedTreeForSum2(int length) {
                sum = new int[length + 1];// 0处不使用，所以需要多一位的长度
            }

            public void add(int index, int num) {
                for (int i = index + 1; i < sum.length; i += lowbit(i))
                    sum[i] += num;
            }

            /**
             * 区间赋值
             * 
             * @param index     为了保持习惯，依然当作0开始，但实际上修改的是数组中的index+1位置
             * @param num       让index位置上的值加上这个值
             */
            public void add(int indexFrom, int indexTo, int num) {
                add(indexFrom, num);
                add(indexTo, -num);
            }

            public void addInclude(int indexFrom, int indexTo, int num) {
                add(indexFrom, num);
                add(indexTo + 1, -num);
            }

            /**
             * 单点查询
             * 
             * @param index     
             * @return          返回index位置的值
             */
            public int get(int index) {
                int sum = 0;

                // 由于index对应数组index+1的位置，从index开始加正好不包括index+1位置上的值
                for (int i = index + 1; i > 0; i -= lowbit(i))
                    sum += this.sum[i];

                return sum;
            }
        }

        public int[] getModifiedArray(int length, int[][] updates) {
            IntBinaryIndexedTreeForSum2 bit = new IntBinaryIndexedTreeForSum2(length);
            for (int i = 0; i < updates.length; ++i) {
                bit.addInclude(updates[i][0], updates[i][1], updates[i][2]);
            }
            int[] ans = new int[length];
            for (int i = 0; i < length; ++i) {
                ans[i] = bit.get(i);
            }
            return ans;
        }
    }



}

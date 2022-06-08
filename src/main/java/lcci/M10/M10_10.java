package lcci.M10;

/**  
 * @ClassName: M10_10  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月9日  
 *  
 */
public class M10_10 {

    class StreamRank {

        private IntBinaryIndexedTreeForSum2 bit = new IntBinaryIndexedTreeForSum2(50001);

        public StreamRank() {}

        public void track(int x) {
            bit.add(x, 1);
        }

        public int getRankOfNumber(int x) {
            return bit.get(x);
        }

        public class IntBinaryIndexedTreeForSum2 {

            private int[] sum;// 对应的树状数组

            int lowbit(int x) {
                return x & -x;
            }

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
    }

}

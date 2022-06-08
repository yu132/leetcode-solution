package redo.Util.ds.binaryIndexedTree;

/**
 * @author 余定邦
 * @ClassName: RangeUpdateSingleQuery
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2021年1月9日
 */
public class RangeUpdateSingleQuery {

    class BinaryIndexedTree {
        private int[] sum;// 对应的树状数组

        public int size() {
            return sum.length - 1;
        }

        public BinaryIndexedTree(int length) {
            sum = new int[length + 1];// 0处不使用，所以需要多一位的长度
        }

        //不要使用这个方法更新，并不是单点更新，而是内部更新方法
        private void add(int index, int num) {
            for (int i = index + 1; i < sum.length; i += lowbit(i)) {
                sum[i] += num;
            }
        }

        // 让indexFrom-indexTo(不包括)位置上的值加上这个值
        public void add(int indexFrom, int indexTo, int num) {
            add(indexFrom, num);
            add(indexTo, -num);
        }

        // 让indexFrom-indexTo(包括)位置上的值加上这个值
        public void addInclude(int indexFrom, int indexTo, int num) {
            add(indexFrom, num);
            add(indexTo + 1, -num);
        }

        // 返回index位置的值
        public int get(int index) {
            int sum = 0;

            // 由于index对应数组index+1的位置，从index开始加正好不包括index+1位置上的值
            for (int i = index + 1; i > 0; i -= lowbit(i))
                sum += this.sum[i];

            return sum;
        }

        int lowbit(int x) {
            return x & -x;
        }
    }

}

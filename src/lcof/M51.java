package lcof;

import java.util.Arrays;

/**  
 * @ClassName: M51  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月22日  
 *  
 */
public class M51 {

    // class Solution {
    // public int reversePairs(int[] nums) {
    // return countInversion(nums);
    // }
    //
    // public int countInversion(int[] array) {
    //
    // int[] b = discretize(array); // 离散化
    //
    // IntBinaryIndexedTreeForSum bit = new IntBinaryIndexedTreeForSum(array.length + 1);
    //
    // int count = 0;
    //
    // for (int i = 0; i < b.length; ++i) {// 元素索引从0开始，i + 1表示当前元素数量
    // bit.add(b[i], 1);// 当前元素的位置上加1
    // count += i + 1 - bit.getSumInclude(b[i]);// 总计数加上 当前总量减去排在这个元素前面和这个元素本身的数量
    // // 即总计数加上比这个数大的数量，而且这些元素都比这个元素出现的早
    // }
    //
    // return count;
    // }
    //
    // private class Node {
    // int val;
    // int id;
    //
    // public Node(int val, int id) {
    // super();
    // this.val = val;
    // this.id = id;
    // }
    // }
    //
    // public int[] discretize(int[] array) {
    //
    // Node[] nodes = new Node[array.length];
    //
    // Arrays.setAll(nodes, (i) -> new Node(array[i], i));
    //
    // Arrays.sort(nodes, (a, b) -> Integer.compare(a.val, b.val));
    //
    // int[] discretizedArray = new int[array.length];
    //
    // for (int i = 0; i < discretizedArray.length; ++i)
    // discretizedArray[nodes[i].id] = i;
    //
    // return discretizedArray;
    // }
    //
    // public class IntBinaryIndexedTreeForSum {
    //
    // // private int[] a;//真实的数组情况
    //
    // private int[] c;// 对应的树状数组
    //
    // public int size() {
    // return c.length - 1;
    // }
    //
    // public IntBinaryIndexedTreeForSum(int length) {
    // // a = new int[length];
    // c = new int[length + 1];// 0处不使用，所以需要多一位的长度
    // }
    //
    // int lowbit(int x) {
    // return x & -x;
    // }
    //
    //
    // // /**
    // // * 单点赋值
    // // *
    // // * 不要单点赋值的话就可以不要数组a
    // // *
    // // * @param index 为了保持习惯，依然当作0开始，但实际上修改的是数组中的index+1位置
    // // * @param num 设置index位置上的值
    // // */
    // // public void set(int index, int num) {
    // // for (int i = index + 1; i < c.length; i += lowbit(i))
    // // c[i] += num - a[index];
    // // a[index] = num;
    // // }
    //
    // /**
    // * 单点更新
    // *
    // * @param index 为了保持习惯，依然当作0开始，但实际上修改的是数组中的index+1位置
    // * @param num 让index位置上的值加上这个值
    // */
    // public void add(int index, int num) {
    // for (int i = index + 1; i < c.length; i += lowbit(i))
    // c[i] += num;
    // // a[index] += num;
    // }
    //
    // /**
    // * 区间查询
    // *
    // * @param index 为了习惯，写成了不包含这个位置的格式
    // * @return 返回0-index(不包括)的区间和
    // */
    // public int getSum(int index) {
    // int sum = 0;
    //
    // // 由于index对应数组index+1的位置，从index开始加正好不包括index+1位置上的值
    // for (int i = index; i > 0; i -= lowbit(i))
    // sum += c[i];
    //
    // return sum;
    // }
    //
    // /**
    // * 区间查询
    // *
    // * @param index
    // * @return 返回0-index(包括)的区间和
    // */
    // public int getSumInclude(int index) {
    // int sum = 0;
    //
    // // 由于index对应数组index+1的位置，从index开始加正好不包括index+1位置上的值
    // for (int i = index + 1; i > 0; i -= lowbit(i))
    // sum += c[i];
    //
    // return sum;
    // }
    //
    // /**
    // * 区间查询
    // *
    // * @param indexFrom 区间的开始索引
    // * @param indexTo 区间的结束索引（不包括）
    // * @return 区间和
    // */
    // public int getSumRange(int indexFrom, int indexTo) {
    // return getSum(indexTo) - getSum(indexFrom);
    // }
    //
    // /**
    // * 区间查询
    // *
    // * @param indexFrom 区间的开始索引
    // * @param indexTo 区间的结束索引（包括）
    // * @return 区间和
    // */
    // public int getSumRangeInclude(int indexFrom, int indexTo) {
    // return getSumInclude(indexTo) - getSum(indexFrom);
    // }
    //
    // }
    // }
    class Solution {
        public int reversePairs(int[] nums) {
            mergeSort(nums, 0, nums.length);
            return res;
        }

        private int res = 0;

        private void mergeSort(int[] array, int from, int to) {
            if (from >= to - 1) {
                return;
            }

            int mid = (from + to) >>> 1;

            mergeSort(array, from, mid);
            mergeSort(array, mid, to);
            merge(array, from, mid, to);
        }

        private void merge(int[] array, int from, int mid, int to) {

            int[] copy  = Arrays.copyOfRange(array, from, mid);

            int   index = from, index1 = from, index2 = mid;

            while (index1 != mid && index2 != to) {
                if (copy[index1 - from] <= array[index2]) {
                    array[index++] = copy[index1++ - from];
                } else {
                    res            += mid - index1;
                    array[index++]  = array[index2++];
                }
            }

            while (index1 != mid) {
                array[index++] = copy[index1++ - from];
            }
            while (index2 != to) {
                array[index++] = array[index2++];
            }
        }
    }



}

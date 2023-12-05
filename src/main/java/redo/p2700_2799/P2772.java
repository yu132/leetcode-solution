package redo.p2700_2799;

public class P2772 {

    class Solution {
        public boolean checkArray(int[] nums, int k) {
            BinaryIndexedTree bit = new BinaryIndexedTree(nums.length);
            for (int i = 0; i <= nums.length - k; ++i) {
                int now = bit.get(i);
                if (now > nums[i]) {
                    return false;
                } else if (now < nums[i]) {
                    bit.add(i, i + k, nums[i] - now);
                }
            }
            for (int i = nums.length - k + 1; i < nums.length; ++i) {
                if (bit.get(i) != nums[i]) {
                    return false;
                }
            }
            return true;
        }

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

}

package redo.p0300_0399;

import redo.testUtil.Arrs;

import java.util.Arrays;
import java.util.TreeMap;

public class P327 {

    class Solution {
        public int countRangeSum(int[] nums, int lower, int upper) {

            long[] prefix = prefix(nums);
            Arrays.sort(prefix);

            TreeMap<Long, Integer> treeMap = new TreeMap<>();
            treeMap.put(Long.MIN_VALUE, 0);
            for (int i = 0; i < prefix.length; ++i) {
                if (treeMap.containsKey(prefix[i])) {
                    continue;
                }
                treeMap.put(prefix[i], treeMap.size());
            }
            treeMap.put(Long.MAX_VALUE, treeMap.size());

            BinaryIndexedTree bit = new BinaryIndexedTree(treeMap.size());

            int ans = 0;

            long nowPrefix = 0;
            bit.add(treeMap.get(nowPrefix), 1);
            for (int i = 0; i < nums.length; ++i) {
                // lower <= nowPrefix - prefix[j] <= upper
                // prefix[j] <= nowPrefix - lower
                // prefix[j] >= nowPrefix - upper
                nowPrefix += nums[i];
                long lKey = nowPrefix - upper;
                long rKey = nowPrefix - lower;
                int ll = treeMap.ceilingEntry(lKey).getValue();
                int rr = treeMap.floorEntry(rKey).getValue();
                if (ll <= rr) {
                    ans += bit.getSumRangeInclude(ll, rr);
                }
                bit.add(treeMap.get(nowPrefix), 1);
            }
            return ans;
        }

        public class BinaryIndexedTree {
            // private int[] a;//真实的数组情况

            private int[] c;// 对应的树状数组

            public int size() {
                return c.length - 1;
            }

            // length是树状数组的长度，即只能存储0到length-1长的值，如果取值区间为0到length，那么要+1
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

        // 前缀和 sum(0 to i)=prefix[i+1];
        long[] prefix(int[] nums) {
            long[] prefix = new long[nums.length + 1];
            for (int i = 0; i < nums.length; ++i) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
            return prefix;
        }
    }

    public static void main(String[] args) {
        int ans = new P327().new Solution().countRangeSum(Arrs.build("[-2,5,-1]"), -2, 2);
        System.out.println(ans);
    }

}

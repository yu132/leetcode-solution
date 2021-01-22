package redo.p1100_1199;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1130  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月14日  
 *  
 */
public class P1130 {

    static//

    class Solution {
        public int mctFromLeafValues(int[] arr) {
            SimpleIntArrayDeque deque = new SimpleIntArrayDeque(arr.length + 1);
            deque.offerLast(Integer.MAX_VALUE);
            int ans = 0;
            for (int num : arr) {
                while (num > deque.peekLast()) {
                    ans += deque.pollLast() * Math.min(deque.peekLast(), num);
                }
                deque.offerLast(num);
            }
            while (deque.size() > 2) {
                ans += deque.pollLast() * deque.peekLast();
            }
            return ans;
        }

        static class SimpleIntArrayDeque {

            int start = 0, end = 0, deque[];

            public SimpleIntArrayDeque(int len) {
                super();
                this.deque = new int[len];
            }

            public void offerLast(int num) {
                deque[end++] = num;
            }

            public int pollLast() {
                return deque[--end];
            }

            public int peekLast() {
                return deque[end - 1];
            }

            public int pollFirst() {
                return deque[start++];
            }

            public int peekFirst() {
                return deque[start];
            }

            public boolean isEmpty() {
                return start == end;
            }

            public int size() {
                return end - start;
            }

            public void clear() {
                start = end = 0;
            }
        }
    }

    // class Solution {
    //
    // int[][][] dp;
    //
    // public int mctFromLeafValues(int[] arr) {
    // dp = new int[arr.length][arr.length + 1][];
    // return dp(0, arr.length, arr)[0];
    // }
    //
    // public int[] dp(int start, int end, int[] arr) {
    // if (start == end - 1) {
    // return new int[] {0, arr[start]};
    // } else if (start == end - 2) {
    // return new int[] {arr[start] * arr[start + 1], Math.max(arr[start], arr[start + 1])};
    // }
    // if (dp[start][end] == null) {
    // int min = Integer.MAX_VALUE, max = 0;
    // for (int i = start + 1; i < end; ++i) {
    // int[] left = dp(start, i, arr);
    // int[] right = dp(i, end, arr);
    // int sum = left[0] + right[0] + left[1] * right[1];
    // if (sum < min) {
    // min = sum;
    // max = Math.max(left[1], right[1]);
    // }
    // }
    // dp[start][end] = new int[] {min, max};
    // }
    // return dp[start][end];
    // }
    // }

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(32, s.mctFromLeafValues(new int[] {6, 2, 4}));
        Assert.assertEquals(284, s.mctFromLeafValues(new int[] {7, 12, 8, 10}));

        Assert.assertEquals(500, s.mctFromLeafValues(new int[] {15, 13, 5, 3, 15}));

        Assert.assertEquals(20, s.mctFromLeafValues(new int[] {4, 3, 2, 1}));
    }

}

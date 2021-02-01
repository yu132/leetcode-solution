package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P907  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月25日  
 *  
 */
public class P907 {

    static//

    class Solution {

        public final static int MOD = 1_000_000_007;

        public int sumSubarrayMins(int[] arr) {
            SimpleIntArrayDeque mqueue = new SimpleIntArrayDeque(arr.length);

            long ans = 0;
            for (int i = 0; i < arr.length; ++i) {
                while (!mqueue.isEmpty() && arr[mqueue.peekLast()] >= arr[i]) {
                    int mid = mqueue.pollLast(), right = i, left = mqueue.isEmpty() ? -1 : mqueue.peekLast();
                    ans = (ans + (long)(mid - left) * (right - mid) * arr[mid]) % MOD;
                }
                mqueue.offerLast(i);
            }

            while (!mqueue.isEmpty()) {
                int mid = mqueue.pollLast(), right = arr.length, left = mqueue.isEmpty() ? -1 : mqueue.peekLast();
                ans = (ans + (long)(mid - left) * (right - mid) * arr[mid]) % MOD;
            }

            return (int)ans;
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



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(17, s.sumSubarrayMins(new int[] {3, 1, 2, 4}));
    }

}

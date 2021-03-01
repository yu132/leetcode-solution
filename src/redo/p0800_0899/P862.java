package redo.p0800_0899;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P862  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月25日  
 *  
 */
public class P862 {

    class Solution {
        public int shortestSubarray(int[] A, int K) {

            long[] p = new long[A.length + 1];

            for (int i = 0; i < A.length; ++i) {
                p[i + 1] = p[i] + A[i];
            }

            int ans = Integer.MAX_VALUE;

            Deque<Integer> mqueue = new LinkedList<>();

            for (int i = 0; i <= A.length; ++i) {
                while (!mqueue.isEmpty() && p[mqueue.peekLast()] >= p[i]) {
                    mqueue.pollLast();
                }
                while (!mqueue.isEmpty() && p[mqueue.peekFirst()] + K <= p[i]) {
                    ans = Math.min(ans, i - mqueue.pollFirst());
                }
                mqueue.offerLast(i);
            }

            if (ans == Integer.MAX_VALUE) {
                return -1;
            }

            return ans;
        }
    }


    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3,
            s.shortestSubarray(new int[] {84, -37, 32, 40, 95}, 167));
    }

}

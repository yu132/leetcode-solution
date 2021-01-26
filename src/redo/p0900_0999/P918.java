package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P918  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月25日  
 *  
 */
public class P918 {

    class Solution {
        public int maxSubarraySumCircular(int[] A) {
            int last = 0, max = Integer.MIN_VALUE, min = 0, sum = 0;
            for (int i = 0; i < A.length; ++i) {
                sum += A[i];
                last = A[i] + Math.max(last, 0);
                max = Math.max(max, last);
            }
            last = 0;
            for (int i = 1; i < A.length - 1; ++i) {
                last = A[i] + Math.min(last, 0);
                min = Math.min(min, last);
            }
            return Math.max(max, sum - min);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.maxSubarraySumCircular(new int[] {1, -2, 3, -2}));
        Assert.assertEquals(10, s.maxSubarraySumCircular(new int[] {5, -3, 5}));
        Assert.assertEquals(4, s.maxSubarraySumCircular(new int[] {3, -1, 2, -1}));
        Assert.assertEquals(3, s.maxSubarraySumCircular(new int[] {3, -2, 2, -3}));
        Assert.assertEquals(-1, s.maxSubarraySumCircular(new int[] {-2, -3, -1}));
        Assert.assertEquals(-2, s.maxSubarraySumCircular(new int[] {-2}));
    }

}

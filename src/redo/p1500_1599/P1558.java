package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1558  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月5日  
 *  
 */
public class P1558 {

    class Solution {
        public int minOperations(int[] nums) {

            int ans = 0, maxBitLen = 0;

            for (int i = 0; i < nums.length; ++i) {
                ans += Integer.bitCount(nums[i]);
                maxBitLen |= nums[i];
            }

            return ans + bitLenMinus1(maxBitLen);
        }

        public int bitLenMinus1(int num) {
            int temp, len = 0;
            if ((temp = num >>> 16) != 0) {
                num = temp;
                len += 16;
            }
            if ((temp = num >>> 8) != 0) {
                num = temp;
                len += 8;
            }
            if ((temp = num >>> 4) != 0) {
                num = temp;
                len += 4;
            }
            if ((temp = num >>> 2) != 0) {
                num = temp;
                len += 2;
            }
            if ((temp = num >>> 1) != 0) {
                num = temp;
                len += 1;
            }
            return len;
        }
    }


    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(5, s.minOperations(new int[] {1, 5}));
        Assert.assertEquals(3, s.minOperations(new int[] {2, 2}));
        Assert.assertEquals(6, s.minOperations(new int[] {4, 2, 5}));
        Assert.assertEquals(7, s.minOperations(new int[] {3, 2, 2, 4}));
        Assert.assertEquals(8, s.minOperations(new int[] {2, 4, 8, 16}));
        Assert.assertEquals(13, s.minOperations(new int[] {15, 14, 13}));
        Assert.assertEquals(61, s.minOperations(new int[] {423412, 657, 345123, 7567346}));
        Assert.assertEquals(0, s.minOperations(new int[] {0}));
    }

}

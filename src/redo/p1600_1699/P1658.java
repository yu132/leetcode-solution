package redo.p1600_1699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1658  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月2日  
 *  
 */
public class P1658 {

    class Solution {
        public int minOperations(int[] nums, int x) {
            int num = nums[0], indexL = 0, indexR = nums.length - 1, min = Integer.MAX_VALUE;
            while (num < x) {
                if (indexL + 1 == nums.length) {
                    return -1;
                }
                num += nums[++indexL];
            }
            while (true) {
                if (num >= x) {
                    if (num == x) {
                        min = Math.min(min, indexL + nums.length - indexR);
                    }
                    if (indexL == -1) {
                        break;
                    }
                    num -= nums[indexL];
                    --indexL;
                } else if (num < x) {
                    num += nums[indexR];
                    --indexR;
                }
            }
            return min == Integer.MAX_VALUE ? -1 : min;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.minOperations(new int[] {1, 1, 4, 2, 3}, 5));
        Assert.assertEquals(-1, s.minOperations(new int[] {5, 6, 7, 8, 9}, 4));
        Assert.assertEquals(5, s.minOperations(new int[] {3, 2, 20, 1, 1, 3}, 10));
        Assert.assertEquals(-1, s.minOperations(new int[] {1, 1}, 10));
    }

}

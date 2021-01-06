package redo.p1600_1699;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1648  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月2日  
 *  
 */
public class P1648 {

    class Solution {

        private final static int MOD = 1000000007;

        public int maxProfit(int[] inventory, int orders) {
            Arrays.sort(inventory);
            long sum = 0;
            int now = inventory[inventory.length - 1], num = 1;
            for (int i = inventory.length - 2; i >= 0; --i) {
                int diff = now - inventory[i];
                int diffTotalNum = num * diff;
                if (diffTotalNum > orders) {
                    break;
                }
                sum += (long)(inventory[i] + 1 + now) * diff / 2 * num;
                sum %= MOD;
                now = inventory[i];
                orders -= diffTotalNum;
                ++num;
            }
            if (orders != 0) {
                int completeGroup = orders / num;
                orders -= completeGroup * num;
                long start = now - completeGroup + 1;
                sum += (start + now) * completeGroup / 2 * num;
                sum += orders * (start - 1);
                sum %= MOD;
            }
            return (int)sum;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(14, s.maxProfit(new int[] {2, 5}, 4));
        Assert.assertEquals(19, s.maxProfit(new int[] {3, 5}, 6));
        Assert.assertEquals(110, s.maxProfit(new int[] {2, 8, 4, 10, 6}, 20));
        Assert.assertEquals(21, s.maxProfit(new int[] {1000000000}, 1000000000));
        Assert.assertEquals(373219333, s.maxProfit(new int[] {497978859, 167261111, 483575207, 591815159}, 836556809));
    }

}

package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1599  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月3日  
 *  
 */
public class P1599 {

    class Solution {
        public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
            if (4 * boardingCost <= runningCost) {
                return -1;
            }
            int minRound = -1, maxProfit = 0, numOfCustomer = 0, profitNow = 0;
            for (int i = 0; i < customers.length; ++i) {
                numOfCustomer += customers[i];
                int numInBoard = Math.min(numOfCustomer, 4);
                numOfCustomer -= numInBoard;
                profitNow += numInBoard * boardingCost - runningCost;
                if (profitNow > maxProfit) {
                    maxProfit = profitNow;
                    minRound = i + 1;
                }
            }
            int fullTimes = (numOfCustomer / 4);
            profitNow += fullTimes * (4 * boardingCost - runningCost);
            if (profitNow > maxProfit) {
                maxProfit = profitNow;
                minRound = customers.length + fullTimes;
            }
            profitNow += (numOfCustomer % 4) * boardingCost - runningCost;
            if (profitNow > maxProfit) {
                return customers.length + fullTimes + 1;
            }
            return minRound;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.minOperationsMaxProfit(new int[] {8, 3}, 5, 6));
        Assert.assertEquals(7, s.minOperationsMaxProfit(new int[] {10, 9, 6}, 6, 4));
        Assert.assertEquals(-1, s.minOperationsMaxProfit(new int[] {3, 4, 0, 5, 1}, 1, 92));
        Assert.assertEquals(9, s.minOperationsMaxProfit(new int[] {10, 10, 6, 4, 7}, 3, 8));
        Assert.assertEquals(1, s.minOperationsMaxProfit(new int[] {4, 0, 0, 0, 0, 0, 0, 0, 0, 1}, 3, 8));
        Assert.assertEquals(2, s.minOperationsMaxProfit(new int[] {6, 0, 0, 0, 0, 0, 0, 0, 0, 1}, 5, 8));

    }

}

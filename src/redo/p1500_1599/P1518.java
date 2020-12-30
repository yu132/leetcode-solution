package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1518  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1518 {

    class Solution {
        public int numWaterBottles(int numBottles, int numExchange) {
            int ans = numBottles;
            while (numBottles >= numExchange) {
                ans += numBottles / numExchange;
                numBottles = numBottles / numExchange + numBottles % numExchange;
            }
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(13, s.numWaterBottles(9, 3));
        Assert.assertEquals(19, s.numWaterBottles(15, 4));
        Assert.assertEquals(6, s.numWaterBottles(5, 5));
        Assert.assertEquals(2, s.numWaterBottles(2, 3));
    }

}

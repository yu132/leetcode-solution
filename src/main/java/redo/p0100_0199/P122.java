package redo.p0100_0199;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P122  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月17日  
 *  
 */
public class P122 {

    class Solution {
        public int maxProfit(int[] prices) {
            int sum = 0;
            for (int i = 1; i < prices.length; ++i) {
                sum += Math.max(0, prices[i] - prices[i - 1]);
            }
            return sum;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(7, s.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
        assertEquals(4, s.maxProfit(new int[] {1, 2, 3, 4, 5}));
        assertEquals(0, s.maxProfit(new int[] {7, 6, 4, 3, 1}));
        assertEquals(0, s.maxProfit(new int[] {}));
    }

}

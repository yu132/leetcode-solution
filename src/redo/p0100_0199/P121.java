package redo.p0100_0199;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P121  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月17日  
 *  
 */
public class P121 {

    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            int max = 0;
            int min = prices[0];
            for (int i = 1; i < prices.length; ++i) {
                max = Math.max(max, prices[i] - min);
                min = Math.min(min, prices[i]);
            }
            return max;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(5, s.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
        assertEquals(0, s.maxProfit(new int[] {7, 6, 4, 3, 1}));
        assertEquals(0, s.maxProfit(new int[] {}));
    }

}

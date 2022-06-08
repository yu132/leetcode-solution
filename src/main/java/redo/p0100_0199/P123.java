package redo.p0100_0199;

/**  
 * @ClassName: P123  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月23日  
 *  
 */
public class P123 {

    class Solution {
        public int maxProfit(int[] prices) {
            int b1 = -prices[0], b2 = -prices[0], s1 = 0, s2 = 0;
            for (int i = 1; i < prices.length; ++i) {
                int p = prices[i];
                b1 = Math.max(b1, -p);
                s1 = Math.max(s1, b1 + p);
                b2 = Math.max(b2, s1 - p);
                s2 = Math.max(s2, b2 + p);
            }
            return s2;
        }
    }

}

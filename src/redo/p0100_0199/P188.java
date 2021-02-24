package redo.p0100_0199;

import java.util.Arrays;

/**  
 * @ClassName: P188  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月23日  
 *  
 */
public class P188 {

    class Solution {
        public int maxProfit(int k, int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            int[] b = new int[k], s = new int[k];
            Arrays.fill(b, -prices[0]);
            for (int i = 1; i < prices.length; ++i) {
                int p = prices[i];

                b[0] = Math.max(b[0], -p);
                s[0] = Math.max(s[0], b[0] + p);
                for (int j = 1; j < k; ++j) {
                    b[j] = Math.max(b[j], s[j - 1] - p);
                    s[j] = Math.max(s[j], b[j] + p);
                }
            }
            return s[k - 1];
        }
    }

}

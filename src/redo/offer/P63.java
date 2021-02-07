package redo.offer;

import javax.annotation.PreDestroy;

/**  
 * @ClassName: P63  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P63 {

    class Solution {
        public int maxProfit(int[] prices) {
            int max = 0, min = Integer.MAX_VALUE;
            for (int i = 0; i < prices.length; ++i) {
                min = Math.min(min, prices[i]);
                max = Math.max(max, prices[i] - min);
            }
            return max;
        }
    }

}

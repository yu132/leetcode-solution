package lcof;

/**  
 * @ClassName: M63  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月24日  
 *  
 */
public class M63 {

    class Solution {
        public int maxProfit(int[] prices) {

            if (prices.length <= 1) {
                return 0;
            }

            int min = prices[0], max = 0;

            for (int i = 1; i < prices.length; ++i) {
                max = Math.max(max, prices[i] - min);
                min = Math.min(min, prices[i]);
            }

            return max;
        }
    }

}

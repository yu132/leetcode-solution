package _1400_1499;

/**  
 * @ClassName: _1475  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年6月26日  
 *  
 */
public class _1475 {

    class Solution {
        public int[] finalPrices(int[] prices) {

            for (int i = 0; i < prices.length; ++i) {
                for (int j = i + 1; j < prices.length; ++j) {
                    if (prices[i] >= prices[j]) {
                        prices[i] -= prices[j];
                        break;
                    }
                }
            }
            return prices;
        }
    }

}

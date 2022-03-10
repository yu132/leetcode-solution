package redo2012_05_29start;

/**  
 * @ClassName: P121  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年5月30日  
 *  
 */
public class P0121 {

    class Solution {
        public int maxProfit(int[] prices) {
            int maxProfit = 0, minPrice = Integer.MAX_VALUE;
            for (int price : prices) {
                maxProfit = Math.max(maxProfit, price - minPrice);
                minPrice = Math.min(minPrice, price);
            }
            return maxProfit;
        }
    }

}

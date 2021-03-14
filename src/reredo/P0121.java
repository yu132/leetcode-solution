package reredo;

/**  
 * @ClassName: P121  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月2日  
 *  
 */
public class P0121 {

    class Solution {
        public int maxProfit(int[] prices) {

            int maxProfit = 0, min = Integer.MAX_VALUE;

            for (int price : prices) {
                min = Math.min(min, price);
                maxProfit = Math.max(maxProfit, price - min);
            }

            return maxProfit;
        }
    }

}

package reredo.rrrd;

/**  
 * @ClassName: P121  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月25日  
 *  
 */
public class P121 {

    class Solution {
        public int maxProfit(int[] prices) {
            int min = Integer.MAX_VALUE, max = 0;
            for (int price : prices) {
                min = Math.min(min, price);
                max = Math.max(max, price - min);
            }
            return max;
        }
    }

}

package redo.p0300_0399;

/**  
 * @ClassName: P309  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月15日  
 *  
 */
public class P309 {

    class Solution {
        public int maxProfit(int[] prices) {
            int own = Integer.MIN_VALUE, sell = 0, notOwn = 0;

            for (int price : prices) {
                int o = own, s = sell, n = notOwn;
                own = Math.max(o, n - price);
                sell = o + price;
                notOwn = Math.max(s, n);
            }

            return Math.max(Math.max(own, sell), notOwn);
        }
    }

}

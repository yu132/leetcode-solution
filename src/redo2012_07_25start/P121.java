package redo2012_07_25start;

/**  
 * @ClassName: P121  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年8月8日  
 *  
 */
public class P121 {

    class Solution {
        public int maxProfit(int[] prices) {
            int min = Integer.MAX_VALUE, ans = 0;
            for (int num : prices) {
                min = Math.min(min, num);
                ans = Math.max(num - min, ans);
            }
            return ans;
        }
    }

}

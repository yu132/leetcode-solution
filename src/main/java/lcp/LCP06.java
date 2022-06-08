package lcp;

/**  
 * @ClassName: LCP06  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年5月20日  
 *  
 */
public class LCP06 {

    class Solution {
        public int minCount(int[] coins) {
            int count = 0;
            for (int i = 0; i < coins.length; ++i) {
                count += coins[i] / 2 + (coins[i] & 1);
            }
            return count;
        }
    }

}

package old._1500_1599;

/**  
 * @ClassName: _1518  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年7月28日  
 *  
 */
public class _1518 {

    class Solution {
        public int numWaterBottles(int numBottles, int numExchange) {
            int ans = numBottles, n;
            do {
                n           = numBottles / numExchange;
                ans        += n;
                numBottles  = n + numBottles % numExchange;
            } while (n != 0);
            return ans;
        }
    }

}

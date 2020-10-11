package lcof;

/**  
 * @ClassName: M62  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月24日  
 *  
 */
public class M62 {

    class Solution {
        public int lastRemaining(int n, int m) {
            return josephusRecursion(n, m, n);
        }

        public int josephusRecursion(int totalNumberOfPeople, int dangerNumber, int ithRound) {
            if (ithRound == 1) {
                return (dangerNumber - 1) % totalNumberOfPeople;
            } else {
                return (josephusRecursion(totalNumberOfPeople - 1, dangerNumber, ithRound - 1) + dangerNumber)
                    % totalNumberOfPeople;
            }
        }
    }

}

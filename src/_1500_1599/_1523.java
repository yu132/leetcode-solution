package _1500_1599;

/**  
 * @ClassName: _1523  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年7月28日  
 *  
 */
public class _1523 {

    class Solution {
        public int countOdds(int low, int high) {
            if ((low & 1) == 1) {
                return (high - low) / 2 + 1;
            } else {
                return (high - low + 1) / 2;
            }
        }
    }

}

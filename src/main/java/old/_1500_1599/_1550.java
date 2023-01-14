package old._1500_1599;

/**  
 * @ClassName: _1550  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年8月26日  
 *  
 */
public class _1550 {

    class Solution {
        public boolean threeConsecutiveOdds(int[] arr) {
            int count = 0;
            for (int i = 0; i < arr.length; ++i) {
                if ((arr[i] & 1) == 1) {
                    ++count;
                    if (count == 3) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
            return false;
        }
    }

}

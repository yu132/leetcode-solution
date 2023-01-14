package old._0200_0299;

/**  
 * @ClassName: _266  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月26日  
 *  
 */
public class _266 {

    class Solution {
        public boolean canPermutePalindrome(String s) {

            int[] count = new int[256];

            for (int i = 0; i < s.length(); ++i) {
                ++count[s.charAt(i)];
            }

            int a = 1;
            for (int i = 0; i < count.length; ++i) {
                if ((count[i] & 1) == 1) {
                    --a;
                    if (a < 0) {
                        return false;
                    }
                }
            }
            return true;

        }
    }

}

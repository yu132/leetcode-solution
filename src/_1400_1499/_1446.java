package _1400_1499;

/**  
 * @ClassName: _1446  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年5月20日  
 *  
 */
public class _1446 {

    class Solution {
        public int maxPower(String s) {

            if (s.length() == 0) {
                return 0;
            }

            char now = s.charAt(0);
            int  len = 1, max = 0;

            for (int i = 1; i < s.length(); ++i) {
                if (now == s.charAt(i)) {
                    ++len;
                } else {
                    max = Math.max(max, len);
                    len = 1;
                    now = s.charAt(i);
                }
            }

            max = Math.max(max, len);

            return max;
        }
    }

}

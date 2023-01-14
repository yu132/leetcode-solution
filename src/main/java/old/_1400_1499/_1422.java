package old._1400_1499;

/**  
 * @ClassName: _1422  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年5月14日  
 *  
 */
public class _1422 {

    class Solution {
        public int maxScore(String s) {

            int    _1 = 0, _0 = 0, max = 0;
            char[] c  = s.toCharArray();

            for (char ch : c) {
                if (ch == '1') {
                    ++_1;
                }
            }

            boolean b = true;

            for (char ch : c) {
                if (b) {
                    b = false;
                } else {
                    max = Math.max(max, _1 + _0);
                }
                if (ch == '0') {
                    ++_0;
                } else {
                    --_1;
                }
            }

            return max;
        }
    }

}

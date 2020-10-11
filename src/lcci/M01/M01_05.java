package lcci.M01;

/**  
 * @ClassName: M01_05  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月26日  
 *  
 */
public class M01_05 {

    class Solution {
        public boolean oneEditAway(String first, String second) {

            if (Math.abs(first.length() - second.length()) > 1) {
                return false;
            }

            if (first.length() == second.length()) {

                int diffCount = 0;

                for (int i = 0; i < first.length(); ++i) {
                    if (first.charAt(i) != second.charAt(i)) {
                        ++diffCount;
                        if (diffCount > 1) {
                            return false;
                        }
                    }
                }

            } else {

                boolean fL        = first.length() > second.length();

                String  lstr      = fL ? first : second;
                String  sstr      = fL ? second : first;

                int     diffCount = 0;

                for (int i = 0; i < sstr.length();) {
                    if (sstr.charAt(i) != lstr.charAt(i + diffCount)) {
                        ++diffCount;
                        if (diffCount > 1) {
                            return false;
                        }
                    } else {
                        ++i;
                    }
                }

            }

            return true;
        }
    }

}

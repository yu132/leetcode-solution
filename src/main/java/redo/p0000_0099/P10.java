package redo.p0000_0099;

/**  
 * @ClassName: P10  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月4日  
 *  
 */
public class P10 {

    class Solution {
        public boolean isMatch(String s, String p) {
            return helper(s.length(), p.length(), s, p);
        }

        public boolean helper(int i, int j, String s, String p) {
            if (i == 0 && j == 0) {
                return true;
            }
            if (j == 0) {
                return false;
            }
            if (p.charAt(j - 1) == '*') {
                if (helper(i, j - 2, s, p)) {
                    return true;
                }
                if (match(s, p, i, j - 1) && helper(i - 1, j, s, p)) {
                    return true;
                }
            } else {
                if (match(s, p, i, j) && helper(i - 1, j - 1, s, p)) {
                    return true;
                }
            }
            return false;
        }

        public boolean match(String s, String p, int i, int j) {
            if (i == 0) {
                return false;
            }
            if (p.charAt(j - 1) == '.') {
                return true;
            }
            return s.charAt(i - 1) == p.charAt(j - 1);
        }

    }

}

package redo.p0000_0099;

/**  
 * @ClassName: P32  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月22日  
 *  
 */
public class P32 {

    class Solution {
        public int longestValidParentheses(String s) {
            int left = 0, right = 0, max = 0;
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '(') {
                    ++left;
                } else {
                    ++right;
                }

                if (left == right) {
                    max = Math.max(max, left + right);
                } else if (right > left) {
                    left = right = 0;
                }
            }
            left = right = 0;
            for (int i = s.length() - 1; i >= 0; --i) {
                if (s.charAt(i) == '(') {
                    ++left;
                } else {
                    ++right;
                }

                if (left == right) {
                    max = Math.max(max, left + right);
                } else if (right < left) {
                    left = right = 0;
                }
            }

            return max;
        }
    }

}

package redo.p0000_0099;

/**  
 * @ClassName: P05  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月21日  
 *  
 */
public class P05 {

    class Solution {
        public String longestPalindrome(String s) {

            int max = 0, start = 0;

            for (int i = 0; i < s.length(); ++i) {
                int[] odd = expand(i, i, s), even = expand(i, i + 1, s);
                if (odd[1] - odd[0] > max) {
                    max = odd[1] - odd[0];
                    start = odd[0];
                }
                if (even[1] - even[0] > max) {
                    max = even[1] - even[0];
                    start = even[0];
                }
            }

            return s.substring(start, start + max);
        }

        int[] expand(int i, int j, String s) {
            for (; i >= 0 && j < s.length(); --i, ++j) {
                if (s.charAt(i) != s.charAt(j)) {
                    break;
                }
            }
            return new int[] {i + 1, j};
        }
    }

}

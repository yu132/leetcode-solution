package redo.p0000_0099;

/**  
 * @ClassName: P3  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P03 {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int left = 0, right = 0, max = 0;
            boolean shown[] = new boolean[128];
            for (; right < s.length(); ++right) {
                if (shown[s.charAt(right)]) {
                    while (s.charAt(left) != s.charAt(right)) {
                        shown[s.charAt(left)] = false;
                        ++left;
                    }
                    ++left;
                }
                shown[s.charAt(right)] = true;
                max = Math.max(max, right - left + 1);
            }
            return max;
        }
    }

}

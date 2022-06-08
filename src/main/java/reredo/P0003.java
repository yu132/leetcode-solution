package reredo;

/**  
 * @ClassName: P0003  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月2日  
 *  
 */
public class P0003 {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            boolean[] shown = new boolean[128];

            int n = s.length();
            int max = 0;

            for (int left = 0, right = 0; right < n; ++right) {
                if (!shown[s.charAt(right)]) {
                    shown[s.charAt(right)] = true;
                    max = Math.max(max, right - left + 1);
                } else {
                    while (s.charAt(left) != s.charAt(right)) {
                        ++left;
                    }
                    ++left;
                }
            }

            return max;
        }
    }

}

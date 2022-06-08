package redo2012_07_25start;

/**  
 * @ClassName: P3  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年7月25日  
 *  
 */
public class P3 {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int maxLen = 0;

            boolean[] used = new boolean[128];

            for (int left = 0, right = 0; right < s.length(); ++right) {
                if (used[s.charAt(right)]) {
                    while (s.charAt(left) != s.charAt(right)) {
                        used[s.charAt(left)] = false;
                        ++left;
                    }
                    ++left;
                } else {
                    used[s.charAt(right)] = true;
                }
                maxLen = Math.max(maxLen, right - left);
            }

            return maxLen + 1;
        }
    }

}

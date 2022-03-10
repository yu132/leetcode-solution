package redo2012_05_29start;

/**  
 * @ClassName: P0003  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年5月29日  
 *  
 */
public class P0003 {

    class Solution {
        public int lengthOfLongestSubstring(String s) {

            boolean[] used = new boolean[128];

            int maxLen = 0;

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
                maxLen = Math.max(maxLen, right - left + 1);
            }

            return maxLen;
        }
    }

}

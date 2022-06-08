package reredo.rrrd;

/**  
 * @ClassName: P3  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月24日  
 *  
 */
public class P3 {

    class Solution {
        public int lengthOfLongestSubstring(String s) {

            int max = 0;

            boolean[] shown = new boolean[128];

            for (int left = 0, right = 0; right < s.length(); ++right) {
                if (shown[s.charAt(right)]) {
                    while (s.charAt(left) != s.charAt(right)) {
                        shown[s.charAt(left)] = false;
                        ++left;
                    }
                    ++left;
                } else {
                    shown[s.charAt(right)] = true;
                }
                max = Math.max(max, right - left + 1);
            }

            return max;
        }
    }

}

package lcof;

import java.util.HashMap;
import java.util.Map;

/**  
 * @ClassName: M48  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月21日  
 *  
 */
public class M48 {

    class Solution {
        public int lengthOfLongestSubstring(String s) {

            Map<Character, Integer> map = new HashMap<>();

            int                     now = 0, max = -1;

            for (int i = 0; i < s.length(); ++i) {
                Integer index = map.get(s.charAt(i));
                if (index != null) {
                    max = Math.max(max, i - now);
                    now = Math.max(now, index + 1);
                }
                map.put(s.charAt(i), i);
            }
            max = Math.max(max, s.length() - now);

            return max;
        }
    }

    public static void main(String[] args) {
        new M48().new Solution().lengthOfLongestSubstring("gneuiohnfhndsofhownoaenfanfoidsjhnfoawisenfnizdbgiabkdsn");
    }

}

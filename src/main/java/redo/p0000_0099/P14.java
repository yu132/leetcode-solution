package redo.p0000_0099;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P14  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月16日  
 *  
 */
public class P14 {

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            } else if (strs.length == 1) {
                return strs[0];
            }

            int index = 0;

            l:
            while (true) {
                if (index == strs[0].length()) {
                    break;
                }
                char c = strs[0].charAt(index);
                for (String str : strs) {
                    if (index == str.length() || str.charAt(index) != c) {
                        break l;
                    }
                }
                ++index;
            }

            return strs[0].substring(0, index);
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();

        assertEquals("fl", s.longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
        assertEquals("", s.longestCommonPrefix(new String[] {"dog", "racecar", "car"}));
        assertEquals("", s.longestCommonPrefix(new String[] {"", "", ""}));
    }

}

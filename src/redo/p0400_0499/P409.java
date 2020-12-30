package redo.p0400_0499;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P409  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P409 {

    class Solution {
        public int longestPalindrome(String s) {
            boolean[] has = new boolean[128];
            int len = 0, noused = 0;
            for (char ch : s.toCharArray()) {
                if (has[ch]) {
                    has[ch] = false;
                    len += 2;
                    --noused;
                } else {
                    has[ch] = true;
                    ++noused;
                }
            }
            return len + (noused != 0 ? 1 : 0);
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(7, s.longestPalindrome("abccccdd"));
    }

}

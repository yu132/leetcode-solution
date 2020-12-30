package redo.p0300_0399;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P392  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P392 {

    class Solution {
        public boolean isSubsequence(String s, String t) {
            int i1 = 0, i2 = 0;
            while (i1 != s.length() && i2 != t.length()) {
                if (s.charAt(i1) == t.charAt(i2)) {
                    ++i1;
                }
                ++i2;
            }
            return i1 == s.length();
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(true, s.isSubsequence("abc", "ahbgdc"));
        assertEquals(false, s.isSubsequence("axc", "ahbgdc"));
    }

}

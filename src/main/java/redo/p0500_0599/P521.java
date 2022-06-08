package redo.p0500_0599;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P521  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P521 {

    class Solution {
        public int findLUSlength(String a, String b) {
            if (a.length() != b.length()) {
                return Math.max(a.length(), b.length());
            }
            if (a.equals(b)) {
                return -1;
            } else {
                return a.length();
            }
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.findLUSlength("aba", "cdc"));
        assertEquals(3, s.findLUSlength("aaa", "bbb"));
        assertEquals(-1, s.findLUSlength("aaa", "aaa"));
    }
}

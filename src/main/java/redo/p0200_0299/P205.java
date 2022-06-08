package redo.p0200_0299;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P205  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月18日  
 *  
 */
public class P205 {

    class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] mapping = new int[128];
            boolean[] used = new boolean[128];
            for (int i = 0; i < s.length(); ++i) {
                if (mapping[s.charAt(i)] == 0) {
                    if (used[t.charAt(i)]) {
                        return false;
                    }
                    mapping[s.charAt(i)] = t.charAt(i);
                    used[t.charAt(i)] = true;
                } else {
                    if (mapping[s.charAt(i)] != t.charAt(i)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();

        assertEquals(true, s.isIsomorphic("egg", "add"));
        assertEquals(false, s.isIsomorphic("foo", "bar"));
        assertEquals(true, s.isIsomorphic("papper", "tittle"));
        assertEquals(false, s.isIsomorphic("abc", "ddd"));
        assertEquals(false, s.isIsomorphic("ddd", "abc"));
    }

}

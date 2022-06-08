package redo.p0200_0299;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P242  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月18日  
 *  
 */
public class P242 {

    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] count = new int[26];
            for (char ch : s.toCharArray()) {
                ++count[ch - 'a'];
            }
            for (char ch : t.toCharArray()) {
                --count[ch - 'a'];
                if (count[ch - 'a'] < 0) {
                    return false;
                }
            }
            return true;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(true, s.isAnagram("anagram", "nagaram"));
        assertEquals(false, s.isAnagram("rat", "car"));
    }

}

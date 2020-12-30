package redo.p0300_0399;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P383  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P383 {

    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            if (ransomNote.length() > magazine.length()) {
                return false;
            }
            int[] count = new int[26];
            for (char ch : ransomNote.toCharArray()) {
                ++count[ch - 'a'];
            }
            for (char ch : magazine.toCharArray()) {
                --count[ch - 'a'];
            }
            for (int num : count) {
                if (num > 0) {
                    return false;
                }
            }
            return true;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(false, s.canConstruct("a", "b"));
        assertEquals(false, s.canConstruct("aa", "ab"));
        assertEquals(true, s.canConstruct("aa", "aab"));
    }
}

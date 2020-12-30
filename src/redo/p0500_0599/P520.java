package redo.p0500_0599;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P520  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P520 {

    class Solution {
        public boolean detectCapitalUse(String word) {
            if (Character.isUpperCase(word.charAt(0))) {
                return word.equals(word.toUpperCase()) || word.substring(1).equals(word.substring(1).toLowerCase());
            } else {
                return word.substring(1).equals(word.substring(1).toLowerCase());
            }
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(true, s.detectCapitalUse("USA"));
        assertEquals(true, s.detectCapitalUse("Usa"));
        assertEquals(true, s.detectCapitalUse("usa"));
        assertEquals(false, s.detectCapitalUse("uSA"));
        assertEquals(false, s.detectCapitalUse("UsA"));
    }

}

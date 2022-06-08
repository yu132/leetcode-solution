package redo.p0000_0099;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P58  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月17日  
 *  
 */
public class P58 {

    class Solution {
        public int lengthOfLastWord(String s) {
            int count = 0;
            boolean isWord = false;
            for (int i = s.length() - 1; i >= 0; --i) {
                if (s.charAt(i) == ' ') {
                    if (isWord) {
                        return count;
                    }
                } else {
                    ++count;
                    isWord = true;
                }
            }
            return count;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(6, s.lengthOfLastWord("Hello World!"));
        assertEquals(6, s.lengthOfLastWord("Hello World! "));
        assertEquals(3, s.lengthOfLastWord("aaa"));
    }

}

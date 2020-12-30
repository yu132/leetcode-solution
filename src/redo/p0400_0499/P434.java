package redo.p0400_0499;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P434  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P434 {

    class Solution {
        public int countSegments(String s) {
            boolean isBlank = true;
            int wordNum = 0;
            for (char ch : s.toCharArray()) {
                if (ch == ' ') {
                    if (!isBlank) {
                        isBlank = true;
                    }
                } else {
                    if (isBlank) {
                        ++wordNum;
                        isBlank = false;
                    }
                }
            }
            return wordNum;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(5, s.countSegments("Hello, my name is John"));
        assertEquals(5, s.countSegments("  Hello,   my   name   is   John  "));
        assertEquals(5, s.countSegments("Hello,   my   name   is   John  "));
        assertEquals(0, s.countSegments("   "));
        assertEquals(0, s.countSegments(""));
    }

}

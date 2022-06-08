package redo.p0500_0599;

import static org.junit.Assert.*;

import org.junit.Test;

/**  
 * @ClassName: P551  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P551 {

    class Solution {
        public boolean checkRecord(String s) {
            int A = 0, L = 0;

            for (char ch : s.toCharArray()) {
                switch (ch) {
                    case 'P':
                        L = 0;
                        break;
                    case 'A':
                        L = 0;
                        ++A;
                        if (A > 1) {
                            return false;
                        }
                        break;
                    case 'L':
                        ++L;
                        if (L > 2) {
                            return false;
                        }
                        break;
                }
            }

            return true;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(true, s.checkRecord("PPALLP"));
        assertEquals(false, s.checkRecord("PPALLL"));
        assertEquals(false, s.checkRecord("PPALLA"));
        assertEquals(true, s.checkRecord("LLAL"));
    }
}

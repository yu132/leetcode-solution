package redo.p0400_0499;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P405  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P405 {

    class Solution {

        public String toHex(int num) {
            if (num == 0) {
                return "0";
            }
            int mask = 0x0000000F;
            StringBuilder sb = new StringBuilder();
            while (num != 0) {
                sb.append(toHexCh(num & mask));
                num >>>= 4;
            }
            return sb.reverse().toString();
        }

        private char toHexCh(int num) {
            if (num <= 9) {
                return (char)(num + '0');
            }
            switch (num) {
                case 10:
                    return 'a';
                case 11:
                    return 'b';
                case 12:
                    return 'c';
                case 13:
                    return 'd';
                case 14:
                    return 'e';
                case 15:
                    return 'f';
            }
            throw new RuntimeException("unreachable");
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("1a", s.toHex(26));
        assertEquals("ffffffff", s.toHex(-1));
    }

}

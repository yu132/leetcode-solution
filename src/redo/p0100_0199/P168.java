package redo.p0100_0199;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P168  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月18日  
 *  
 */
public class P168 {

    class Solution {
        public String convertToTitle(int n) {
            n = n - 1;
            StringBuilder sb = new StringBuilder();
            while (n >= 0) {
                sb.append(convert(n % 26));
                n = n / 26 - 1;
            }
            return sb.reverse().toString();
        }

        private char convert(int num) {
            return (char)(num + 'A');
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();

        assertEquals("A", s.convertToTitle(1));
        assertEquals("AB", s.convertToTitle(28));
        assertEquals("ZY", s.convertToTitle(701));
        assertEquals("AUL", s.convertToTitle(1234));
    }

}

package redo.p0400_0499;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P415  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P415 {

    class Solution {
        public String addStrings(String num1, String num2) {
            int inc = 0, index = 0;
            StringBuilder sb = new StringBuilder(Math.max(num1.length(), num2.length()) + 1);
            while (index < num1.length() || index < num2.length()) {
                int a = digits(num1, index);
                int b = digits(num2, index);

                int num = inc + a + b;

                inc = num / 10;
                sb.append(num % 10);
                ++index;
            }
            if (inc != 0) {
                sb.append(inc);
            }
            return sb.reverse().toString();
        }

        public int digits(String num, int index) {
            if (index >= num.length()) {
                return 0;
            }
            return num.charAt(num.length() - index - 1) - '0';
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(String.valueOf(34573247 + 1236123), s.addStrings("34573247", "1236123"));
        assertEquals(String.valueOf(34573247 + 91236123), s.addStrings("34573247", "91236123"));
    }

}

package redo.p0000_0099;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P67  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月17日  
 *  
 */
public class P67 {

    class Solution {
        public String addBinary(String a, String b) {
            int inc = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < Math.max(a.length(), b.length()); ++i) {
                int value = inc + get(a, i) + get(b, i);
                inc = value / 2;
                sb.append(value % 2);
            }
            if (inc == 1) {
                sb.append(inc);
            }
            return sb.reverse().toString();
        }

        public int get(String num, int index) {
            if (index < num.length()) {
                return num.charAt(num.length() - index - 1) - '0';
            }
            return 0;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();

        assertEquals("100", s.addBinary("11", "1"));
        assertEquals("10101", s.addBinary("1010", "1011"));
    }

}

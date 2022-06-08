package redo.p0500_0599;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P504  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P504 {

    class Solution {
        public String convertToBase7(int num) {
            if (num == 0) {
                return "0";
            }
            StringBuilder sb = new StringBuilder();
            boolean neg = false;
            if (num < 0) {
                num = -num;
                neg = true;
            }
            while (num != 0) {
                sb.append(num % 7);
                num /= 7;
            }
            if (neg) {
                sb.append('-');
            }
            return sb.reverse().toString();
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("202", s.convertToBase7(100));
        assertEquals("-10", s.convertToBase7(-7));
        assertEquals("0", s.convertToBase7(0));
    }

}

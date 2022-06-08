package redo.p0000_0099;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P7  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月16日  
 *  
 */
public class P07 {

    class Solution {
        public int reverse(int x) {
            int value = 0;
            while (x != 0) {
                int pop = x % 10;
                x /= 10;
                // 7是因为MAX_VALUE的最后一位为7
                if (value > Integer.MAX_VALUE / 10 || (value == Integer.MAX_VALUE / 10 && pop > 7)) {
                    return 0;
                }
                // -8是因为MIN_VALUE最后一位为-8
                if (value < Integer.MIN_VALUE / 10 || (value == Integer.MIN_VALUE / 10 && pop < -8)) {
                    return 0;
                }
                value = value * 10 + pop;
            }
            return value;
        }
    }


    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(321, s.reverse(123));
        assertEquals(-321, s.reverse(-123));
        assertEquals(21, s.reverse(120));
        assertEquals(0, s.reverse(0));
        assertEquals(0, s.reverse(1534236469));
        assertEquals(0, s.reverse(Integer.MAX_VALUE));
    }

}

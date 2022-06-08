package redo.p1800_1899;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P1869  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年7月26日  
 *  
 */
public class P1869 {

    class Solution {
        public boolean checkZeroOnes(String s) {
            int len = 0, max1 = 0, max0 = 0;
            boolean is0 = false;
            for (char ch : s.toCharArray()) {
                if (is0) {
                    if (ch == '0') {
                        ++len;
                    } else {
                        max0 = Math.max(max0, len);
                        len = 1;
                        is0 = false;
                    }
                } else {
                    if (ch == '0') {
                        max1 = Math.max(max1, len);
                        len = 1;
                        is0 = true;
                    } else {
                        ++len;
                    }
                }
            }
            if (is0) {
                max0 = Math.max(max0, len);
            } else {
                max1 = Math.max(max1, len);
            }
            return max1 > max0;
        }
    }

    @Test
    public void test() {
        assertEquals(false, new Solution().checkZeroOnes("1100"));
    }

}

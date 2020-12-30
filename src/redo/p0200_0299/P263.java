package redo.p0200_0299;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P263  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P263 {

    class Solution {
        public boolean isUgly(int num) {
            if (num <= 0) {
                return false;
            }
            while (num % 2 == 0) {
                num /= 2;
            }
            while (num % 3 == 0) {
                num /= 3;
            }
            while (num % 5 == 0) {
                num /= 5;
            }
            return num == 1;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(true, s.isUgly(6));
        assertEquals(true, s.isUgly(8));
        assertEquals(true, s.isUgly(30));
        assertEquals(false, s.isUgly(14));
        assertEquals(false, s.isUgly(0));
    }

}

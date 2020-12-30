package redo.p0300_0399;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P326  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P326 {

    class Solution {
        public boolean isPowerOfThree(int n) {
            if (n <= 0) {
                return false;
            }
            while (n % 3 == 0) {
                n /= 3;
            }
            return n == 1;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(true, s.isPowerOfThree(27));
        assertEquals(false, s.isPowerOfThree(0));
        assertEquals(true, s.isPowerOfThree(9));
        assertEquals(false, s.isPowerOfThree(45));
    }
}

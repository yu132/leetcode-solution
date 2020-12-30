package redo.p0300_0399;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P342  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P342 {

    class Solution {
        public boolean isPowerOfFour(int n) {
            return (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(true, s.isPowerOfFour(16));
        assertEquals(false, s.isPowerOfFour(100));
        assertEquals(false, s.isPowerOfFour(8));
    }

}

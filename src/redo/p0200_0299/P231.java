package redo.p0200_0299;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P231  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月18日  
 *  
 */
public class P231 {

    class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n <= 0) {
                return false;
            }
            return (n & (n - 1)) == 0;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(true, s.isPowerOfTwo(1));
        assertEquals(true, s.isPowerOfTwo(16));
        assertEquals(false, s.isPowerOfTwo(218));
    }
}

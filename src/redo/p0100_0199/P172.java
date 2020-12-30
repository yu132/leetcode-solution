package redo.p0100_0199;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P172  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月18日  
 *  
 */
public class P172 {

    class Solution {
        public int trailingZeroes(int n) {
            int ans = 0, base = 5;
            while (n / base != 0) {
                ans += n / base;
                base *= 5;
            }
            return ans;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();

        assertEquals(0, s.trailingZeroes(3));
        assertEquals(1, s.trailingZeroes(5));
        assertEquals(2519, s.trailingZeroes(10086));
    }

}

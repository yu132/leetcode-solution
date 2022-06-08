package redo.p0000_0099;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P69  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月17日  
 *  
 */
public class P69 {

    class Solution {
        public int mySqrt(int x) {

            int low = 0, high = (int)Math.sqrt(Integer.MAX_VALUE) + 1;

            while (low < high) {
                int mid = (low + high) >>> 1;
                if (mid * mid <= x) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            return low - 1;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.mySqrt(4));
        assertEquals(2, s.mySqrt(8));
        assertEquals(3, s.mySqrt(15));
        assertEquals(4, s.mySqrt(16));
        assertEquals(4, s.mySqrt(17));
        assertEquals(46340, s.mySqrt(2147395600));
    }

}

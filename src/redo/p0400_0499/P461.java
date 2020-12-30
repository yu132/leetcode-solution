package redo.p0400_0499;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P461  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P461 {

    class Solution {
        public int hammingDistance(int x, int y) {
            int diff = x ^ y;
            int count = 0;
            while (diff != 0) {
                diff &= (diff - 1);
                ++count;
            }
            return count;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.hammingDistance(1, 4));
        assertEquals(24, s.hammingDistance(123123, -1768));
    }

}

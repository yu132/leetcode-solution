package redo.p0200_0299;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P292  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P292 {

    class Solution {
        public boolean canWinNim(int n) {
            return n % 4 != 0;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(false, s.canWinNim(4));
        assertEquals(true, s.canWinNim(2));
    }

}

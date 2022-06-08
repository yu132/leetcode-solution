package redo.p0200_0299;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P202  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月18日  
 *  
 */
public class P202 {

    class Solution {
        public boolean isHappy(int n) {
            int slow = n, fast = n;
            do {
                slow = next(slow);
                fast = next(next(fast));
                if (fast == 1) {
                    return true;
                }
            } while (slow != fast);
            return false;
        }

        public int next(int n) {
            if (n == 1) {
                return 1;
            }
            int next = 0;
            while (n != 0) {
                next += (n % 10) * (n % 10);
                n /= 10;
            }
            return next;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(true, s.isHappy(19));
        assertEquals(false, s.isHappy(145));
    }

}

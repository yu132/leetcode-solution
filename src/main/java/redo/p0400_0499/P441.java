package redo.p0400_0499;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P441  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P441 {

    class Solution {
        public int arrangeCoins(int n) {
            long low = 0, high = (long)n + 1;
            while (low < high) {
                long mid = (low + high) >>> 1;
                if (canBuild(mid, n)) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return (int)(low - 1);
        }

        public boolean canBuild(long level, long num) {
            return level * (1 + level) / 2 <= num;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.arrangeCoins(5));
        assertEquals(3, s.arrangeCoins(8));
        assertEquals(1, s.arrangeCoins(1));
        assertEquals(0, s.arrangeCoins(0));
        assertEquals(60070, s.arrangeCoins(1804289383));
        assertEquals(65535, s.arrangeCoins(2147483647));
    }
}

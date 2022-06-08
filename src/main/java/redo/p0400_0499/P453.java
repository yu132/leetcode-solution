package redo.p0400_0499;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P453  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P453 {

    class Solution {
        public int minMoves(int[] nums) {
            int min = Integer.MAX_VALUE, ans = 0;
            for (int num : nums) {
                min = Math.min(min, num);
            }
            for (int num : nums) {
                ans += num - min;
            }
            return ans;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.minMoves(new int[] {1, 2, 3}));
    }
}

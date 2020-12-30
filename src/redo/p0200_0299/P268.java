package redo.p0200_0299;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P268  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P268 {

    class Solution {
        public int missingNumber(int[] nums) {
            int xor = 0;
            for (int num : nums) {
                xor ^= num;
            }
            for (int i = 0; i <= nums.length; ++i) {
                xor ^= i;
            }
            return xor;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.missingNumber(new int[] {3, 0, 1}));
        assertEquals(2, s.missingNumber(new int[] {0, 1}));
        assertEquals(8, s.missingNumber(new int[] {9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

}

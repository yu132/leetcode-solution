package redo.p0100_0199;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P136  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月17日  
 *  
 */
public class P136 {

    class Solution {
        public int singleNumber(int[] nums) {
            int ans = 0;
            for (int num : nums) {
                ans ^= num;
            }
            return ans;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();

        assertEquals(1, s.singleNumber(new int[] {2, 2, 1}));
        assertEquals(4, s.singleNumber(new int[] {4, 1, 2, 1, 2}));
    }

}

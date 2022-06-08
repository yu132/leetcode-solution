package redo.p0000_0099;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P53  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月17日  
 *  
 */
public class P53 {

    class Solution {
        public int maxSubArray(int[] nums) {
            int sum = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                sum = Math.max(sum + nums[i], nums[i]);
                max = Math.max(max, sum);
            }
            return max;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(6, s.maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(3, s.maxSubArray(new int[] {1, 2}));
        assertEquals(-1, s.maxSubArray(new int[] {-2, -1}));
        assertEquals(-1, s.maxSubArray(new int[] {-2, -1, -3}));
    }

}

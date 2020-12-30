package redo.p0200_0299;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P283  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P283 {

    class Solution {
        public void moveZeroes(int[] nums) {
            int indexFill = 0, indexCheck = 0;
            for (; indexCheck < nums.length; ++indexCheck) {
                if (nums[indexCheck] != 0) {
                    nums[indexFill++] = nums[indexCheck];
                }
            }
            for (; indexFill < nums.length; ++indexFill) {
                nums[indexFill] = 0;
            }
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();

        int[] nums = {0, 1, 0, 3, 12};
        s.moveZeroes(nums);
        assertArrayEquals(new int[] {1, 3, 12, 0, 0}, nums);
    }

}

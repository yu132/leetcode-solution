package _1400_1499;

import java.util.Arrays;

/**  
 * @ClassName: _1470  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年6月8日  
 *  
 */
public class _1470 {

    class Solution {
        public int[] shuffle(int[] nums, int n) {

            int[] copy = Arrays.copyOfRange(nums, 0, nums.length / 2);

            for (int i = 0; i < nums.length / 2; ++i) {
                nums[i * 2 + 1] = nums[nums.length / 2 + i];
            }

            for (int i = 0; i < nums.length / 2; ++i) {
                nums[i * 2] = copy[i];
            }

            return nums;
        }
    }

}

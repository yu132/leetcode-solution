package redo.p0300_0399;

/**  
 * @ClassName: P376  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月15日  
 *  
 */
public class P376 {

    class Solution {
        public int wiggleMaxLength(int[] nums) {
            if (nums.length <= 1) {
                return nums.length;
            }

            int index = 1;

            while (index < nums.length && nums[index] == nums[index - 1]) {
                ++index;
            }

            if (index == nums.length) {
                return 1;
            }

            int val = nums[index], count = 2;
            boolean up = nums[index] > nums[index - 1];
            ++index;

            for (; index < nums.length; ++index) {
                if (up && nums[index] > val) {
                    val = nums[index];
                } else if (!up && nums[index] < val) {
                    val = nums[index];
                } else if (nums[index] == val) {
                    continue;
                } else {
                    ++count;
                    val = nums[index];
                    up = !up;
                }
            }

            return count;
        }
    }

}

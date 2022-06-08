package redo.p1700_1799;

/**  
 * @ClassName: P1752  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月1日  
 *  
 */
public class P1752 {

    class Solution {
        public boolean check(int[] nums) {

            if (nums.length <= 2) {
                return true;
            }

            boolean looseHeight = false;

            int num = nums[0];

            for (int i = 1; i < nums.length; ++i) {
                if (num > nums[i]) {
                    if (looseHeight) {
                        return false;
                    }
                    looseHeight = true;
                }
                num = nums[i];
            }

            if (looseHeight) {
                return nums[nums.length - 1] <= nums[0];
            }

            return true;
        }
    }

}

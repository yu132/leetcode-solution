package redo.p1900_1999;

/**  
 * @ClassName: P1909  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年8月1日  
 *  
 */
public class P1909 {

    class Solution {
        public boolean canBeIncreasing(int[] nums) {
            boolean removed = false;

            for (int i = 1; i < nums.length; ++i) {
                if (nums[i] <= nums[i - 1]) {
                    if (removed) {
                        return false;
                    }
                    if (i >= 2 && nums[i] <= nums[i - 2]) {
                        nums[i] = nums[i - 1];
                    }
                    removed = true;
                }
            }

            return true;
        }
    }

}

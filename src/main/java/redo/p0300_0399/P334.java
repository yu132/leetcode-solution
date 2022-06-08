package redo.p0300_0399;

/**  
 * @ClassName: P334  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P334 {

    class Solution {
        public boolean increasingTriplet(int[] nums) {
            if (nums.length < 3) {
                return false;
            }
            int small = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] <= small) {
                    small = nums[i];
                } else if (nums[i] <= mid) {
                    mid = nums[i];
                } else if (nums[i] > mid) {
                    return true;
                }
            }
            return false;
        }
    }
}


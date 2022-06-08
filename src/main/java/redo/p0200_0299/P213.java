package redo.p0200_0299;

/**  
 * @ClassName: P213  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月22日  
 *  
 */
public class P213 {

    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            return Math.max(helper(nums, 1, nums.length),
                helper(nums, 0, nums.length - 1));
        }

        public int helper(int[] nums, int low, int high) {
            int rob = 0, notRob = 0;
            for (int i = low; i < high; ++i) {
                int lastRob = rob, lastNotRob = notRob;
                rob = lastNotRob + nums[i];
                notRob = Math.max(lastNotRob, lastRob);
            }
            return Math.max(rob, notRob);
        }
    }

}

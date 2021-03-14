package redo.p0000_0099;

/**  
 * @ClassName: P55  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月11日  
 *  
 */
public class P55 {

    class Solution {
        public boolean canJump(int[] nums) {
            int canReach = 0;
            for (int i = 0; i < nums.length && i <= canReach; ++i) {
                canReach = Math.max(canReach, i + nums[i]);
            }
            return canReach >= nums.length - 1;
        }
    }

}

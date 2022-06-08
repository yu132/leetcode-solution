package redo.p0200_0299;

/**  
 * @ClassName: P287  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P287 {

    class Solution {
        public int findDuplicate(int[] nums) {
            int slow = 0, fast = 0;

            do {
                slow = nums[slow];
                fast = nums[nums[fast]];
            } while (slow != fast);

            fast = 0;

            do {
                slow = nums[slow];
                fast = nums[fast];
            } while (slow != fast);

            return slow;
        }
    }

}

package redo.p0000_0099;

/**  
 * @ClassName: P45  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P45 {

    class Solution {
        public int jump(int[] nums) {
            int maxDis = 0, nextMax = 0, jumpTime = 0, index = 0;
            while (maxDis < nums.length - 1) {

                for (; index <= maxDis; ++index) {
                    nextMax = Math.max(nextMax, index + nums[index]);
                }

                ++jumpTime;

                maxDis = nextMax;
            }

            return jumpTime;
        }
    }

}

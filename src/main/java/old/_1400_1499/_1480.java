package old._1400_1499;

/**  
 * @ClassName: _1480  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年6月26日  
 *  
 */
public class _1480 {

    class Solution {
        public int[] runningSum(int[] nums) {
            for (int i = 1; i < nums.length; ++i) {
                nums[i] += nums[i - 1];
            }
            return nums;
        }
    }

}

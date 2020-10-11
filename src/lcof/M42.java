package lcof;

/**  
 * @ClassName: M42  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月20日  
 *  
 */
public class M42 {

    class Solution {
        public int maxSubArray(int[] nums) {
            int now = 0, max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; ++i) {
                now += nums[i];
                max  = Math.max(max, now);
                now  = Math.max(now, 0);
            }
            return max;
        }
    }

}

package redo.offer;

/**  
 * @ClassName: P42  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P42 {

    class Solution {
        public int maxSubArray(int[] nums) {
            int sum = 0, max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; ++i) {
                sum = nums[i] + Math.max(0, sum);
                max = Math.max(sum, max);
            }
            return max;
        }
    }

}

package reredo;

/**  
 * @ClassName: P0053  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月4日  
 *  
 */
public class P0053 {

    class Solution {
        public int maxSubArray(int[] nums) {
            int max = Integer.MIN_VALUE, sum = 0;
            for (int num : nums) {
                sum = Math.max(sum, 0) + num;
                max = Math.max(max, sum);
            }
            return max;
        }
    }

}

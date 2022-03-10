package redo.contest.t233;

/**  
 * @ClassName: P5709  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月21日  
 *  
 */
public class P5709 {

    class Solution {
        public int maxAscendingSum(int[] nums) {

            if (nums.length == 0) {
                return 0;
            }

            int max = nums[0], sum = nums[0], last = nums[0];

            for (int i = 1; i < nums.length; ++i) {
                if (nums[i] > last) {
                    sum += nums[i];
                    last = nums[i];
                } else {
                    max = Math.max(max, sum);
                    last = sum = nums[i];
                }
            }
            max = Math.max(max, sum);

            return max;
        }
    }

}

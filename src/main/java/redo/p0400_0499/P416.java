package redo.p0400_0499;

/**  
 * @ClassName: P416  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月1日  
 *  
 */
public class P416 {

    class Solution {
        public boolean canPartition(int[] nums) {

            int sum = sum(nums);

            if ((sum & 1) == 1) {
                return false;
            }

            int half = sum / 2;

            boolean[] dp = new boolean[half + 1];

            dp[0] = true;

            for (int num : nums) {
                for (int j = half; j >= num; --j) {
                    dp[j] |= dp[j - num];
                }
            }

            return dp[half];
        }

        int sum(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }
    }

}

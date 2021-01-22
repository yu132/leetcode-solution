package redo.Util.ag.subArray.maxSubArr;

/**  
 * @ClassName: MaxSubArrUtil  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月14日  
 *  
 */
public class MaxSubArrUtil {

    static int dp(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; ++i) {
            max = Math.max(max, dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]));
        }
        return max;
    }

    // 其实就是dp优化，由于空间只依赖前一项，因此优化为O(1)
    static int kadane(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int last, max;
        last = max = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            max = Math.max(max, last = Math.max(last + nums[i], nums[i]));
        }
        return max;
    }

    static int kadane2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int last, max;
        last = max = nums[0];
        for (int i = 1; i < nums.length; ++i) {

            if (last + nums[i] < nums[i]) {
                last = nums[i];
            } else {
                last = last + nums[i];
            }

            if (max < last) {
                max = last;
            }
        }
        return max;
    }

}

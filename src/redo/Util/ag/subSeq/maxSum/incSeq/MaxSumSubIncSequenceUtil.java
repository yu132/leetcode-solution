package redo.Util.ag.subSeq.maxSum.incSeq;

/**  
 * @ClassName: MaxSubSequence  
 *
 * @Description: 最大和上升子序列
 *
 * @author 余定邦  
 *
 * @date 2021年1月3日  
 *  
 */
public class MaxSumSubIncSequenceUtil {

    static class MaxSumIncSubSequence {// O(n^2)

        public int maxSum(int[] nums) {
            int[] dp = new int[nums.length];// 记录当前以该数为结尾的最大上升和
            int max = 0;
            for (int i = 0; i < nums.length; ++i) {
                dp[i] = nums[i];
                for (int j = 0; j < i; ++j) {
                    if (nums[j] < nums[i]) {// 上升 < , 不下降 <=
                        // 如果这个本数大于前面的数，就可以接在后面，延长上升和
                        dp[i] = Math.max(dp[i], dp[j] + nums[i]);
                    }
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }

    }

}

package redo.p1000_1099;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1043  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月19日  
 *  
 */
public class P1043 {

    class Solution {

        int[] dp;

        public int maxSumAfterPartitioning(int[] arr, int k) {
            dp = new int[arr.length];
            return dp(arr, 0, k);
        }

        public int dp(int[] arr, int index, int k) {
            if (index == arr.length) {
                return 0;
            }
            if (dp[index] == 0) {
                int max = 0, maxRet = 0;
                for (int i = index; i < Math.min(arr.length, index + k); ++i) {
                    max = Math.max(max, arr[i]);
                    maxRet = Math.max(maxRet, max * (i - index + 1) + dp(arr, i + 1, k));
                }
                dp[index] = maxRet;
            }
            return dp[index];
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(84, s.maxSumAfterPartitioning(new int[] {1, 15, 7, 9, 2, 5, 10}, 3));
        Assert.assertEquals(83, s.maxSumAfterPartitioning(new int[] {1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4));
    }


}

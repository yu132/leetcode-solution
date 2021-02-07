package _0800_0899;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P801  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月1日  
 *  
 */
public class P801 {

    /*
     * 对于i来说，考虑(i-1)一共有3种情况
     * 1.共同有序，交换和不交换都可以
     * 45
     * 45
     * 
     * 2.一致有序，要么两个一起交换，要么都不交换
     * 45
     * 78
     * 
     * 3.交换后有序，要么i处交换，要么i-1处交换
     * 53
     * 26
     */
    class Solution {
        public int minSwap(int[] A, int[] B) {

            int n = A.length;

            int[][] dp = new int[2][2];// 0表示不交换，1表示交换
            dp[0][0] = 0;
            dp[0][1] = 1;
            int scroll = 1;
            for (int i = 1; i < n; ++i, scroll ^= 1) {
                if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                    if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
                        int min =
                            Math.min(dp[scroll ^ 1][0], dp[scroll ^ 1][1]);
                        dp[scroll][0] = min;
                        dp[scroll][1] = min + 1;
                    } else {
                        dp[scroll][0] = dp[scroll ^ 1][0];
                        dp[scroll][1] = dp[scroll ^ 1][1] + 1;
                    }
                } else {
                    dp[scroll][0] = dp[scroll ^ 1][1];
                    dp[scroll][1] = dp[scroll ^ 1][0] + 1;
                }
            }

            return Math.min(dp[scroll ^ 1][0], dp[scroll ^ 1][1]);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1,
            s.minSwap(new int[] {1, 3, 5, 4}, new int[] {1, 2, 3, 7}));
    }

}

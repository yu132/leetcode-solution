package redo.p0800_0899;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P813  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月30日  
 *  
 */
public class P813 {

    class Solution {

        double[][] dp;

        public double largestSumOfAverages(int[] A, int K) {
            dp = new double[A.length][K + 1];
            return dp(0, K, A);
        }

        public double dp(int index, int K, int[] A) {
            if (dp[index][K] == 0) {
                if (K == 1) {
                    int sum = 0;
                    for (int i = index; i < A.length; ++i) {
                        sum += A[i];
                    }
                    dp[index][K] = (double)sum / (A.length - index);
                } else {
                    int sum = 0;
                    for (int i = index; i < A.length - (K - 1); ++i) {
                        sum += A[i];
                        double after = dp(i + 1, K - 1, A);
                        dp[index][K] = Math.max(dp[index][K],
                            (double)sum / (i - index + 1) + after);
                    }
                }
            }
            return dp[index][K];
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(20,
            s.largestSumOfAverages(new int[] {9, 1, 2, 3, 9}, 3), 0.00001);
        Assert.assertEquals(23569.90476,
            s.largestSumOfAverages(new int[] {1, 5, 3, 63, 72, 7, 76, 58, 9, 28,
                3, 456, 234, 8, 2, 845, 9845, 234, 86, 38, 3, 9, 234, 978, 523,
                8967, 4, 1, 7, 23, 7, 234, 8, 345, 745, 123, 856, 123, 745},
                12),
            0.00001);
    }

}

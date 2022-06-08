package redo.p1000_1099;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1027  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月19日  
 *  
 */
public class P1027 {

    class Solution {
        public int longestArithSeqLength(int[] A) {
            int[][] dp = new int[A.length][20001];
            int max = 0;
            for (int i = 0; i < A.length; ++i) {
                for (int j = 0; j < i; ++j) {
                    int diff = A[i] - A[j] + 10000;
                    dp[i][diff] = Math.max(dp[i][diff], dp[j][diff] + 1);
                    max = Math.max(max, dp[i][diff]);
                }
            }
            return max + 1;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.longestArithSeqLength(new int[] {3, 6, 9, 12}));
        Assert.assertEquals(3, s.longestArithSeqLength(new int[] {9, 4, 7, 2, 10}));
        Assert.assertEquals(4, s.longestArithSeqLength(new int[] {20, 1, 15, 3, 10, 5, 8}));
    }

}

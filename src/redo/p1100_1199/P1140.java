package redo.p1100_1199;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P140  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月14日  
 *  
 */
public class P1140 {

    static//

    class Solution {

        int[][][] dp;

        public int stoneGameII(int[] piles) {
            dp = new int[100][piles.length][];
            int[] prefix = prefix(piles);
            return dp(1, 0, piles.length, prefix)[0];
        }

        public static int[] prefix(int[] nums) {
            int[] prefix = new int[nums.length + 1];
            for (int i = 0; i < nums.length; ++i) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
            return prefix;
        }

        public int[] dp(int m, int index, int n, int[] prefix) {
            if (n - index <= 2 * m) {
                return new int[] {prefix[n] - prefix[index], 0};
            }
            if (dp[m][index] == null) {
                int maxSelf = 0, maxOther = 0;
                for (int x = 1; x <= 2 * m; ++x) {
                    int[] sub = dp(Math.max(x, m), index + x, n, prefix);
                    int self = prefix[index + x] - prefix[index] + sub[1];
                    if (self > maxSelf) {
                        maxSelf = self;
                        maxOther = sub[0];
                    }
                }
                dp[m][index] = new int[] {maxSelf, maxOther};
            }
            return dp[m][index];
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(10, s.stoneGameII(new int[] {2, 7, 9, 4, 4}));
    }

}

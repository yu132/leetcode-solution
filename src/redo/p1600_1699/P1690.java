package redo.p1600_1699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1690  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月31日  
 *  
 */
public class P1690 {

    static//

    class Solution {
        int[][][] dp;

        public int stoneGameVII(int[] stones) {
            int[] prefix = prefix(stones);
            dp = new int[stones.length][stones.length][2];
            for (int len = 1; len < stones.length; ++len) {
                for (int i = 0; i < stones.length - len; ++i) {

                    int j = i + len;

                    int[] removeLeft = dp[i + 1][j];
                    int[] removeRight = dp[i][j - 1];
                    int[] now = dp[i][j];

                    int totalRemoveLeftValue = sum(i + 1, j, prefix);
                    int totalRemoveRightValue = sum(i, j - 1, prefix);

                    if (totalRemoveLeftValue - diff(removeLeft) >= totalRemoveRightValue - diff(removeRight)) {
                        now[0] = totalRemoveLeftValue + removeLeft[1];
                        now[1] = removeLeft[0];
                    } else {
                        now[0] = totalRemoveRightValue + removeRight[1];
                        now[1] = removeRight[0];
                    }
                }
            }
            return dp[0][stones.length - 1][0] - dp[0][stones.length - 1][1];
        }

        public int diff(int[] values) {
            return values[0] - values[1];
        }

        public static int[] prefix(int[] nums) {
            int[] prefix = new int[nums.length + 1];
            for (int i = 0; i < nums.length; ++i) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
            return prefix;
        }

        public static int sum(int from, int to, int[] prefix) {
            return prefix[to + 1] - prefix[from];
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(6, s.stoneGameVII(new int[] {5, 2, 1, 4, 2}));
        Assert.assertEquals(122, s.stoneGameVII(new int[] {7, 90, 5, 1, 100, 10, 10, 2}));
    }

}

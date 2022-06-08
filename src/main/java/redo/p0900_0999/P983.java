package redo.p0900_0999;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P983  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月20日  
 *  
 */
public class P983 {

    class Solution {
        public int mincostTickets(int[] days, int[] costs) {
            Arrays.sort(days);
            int[] dp = new int[days[days.length - 1] + 1];
            for (int i = 1, index = 0; index < days.length; ++i) {
                if (i == days[index]) {
                    ++index;
                    dp[i] = costs[0] + dp[i - 1];
                    if (i >= 7) {
                        dp[i] = Math.min(dp[i], costs[1] + dp[i - 7]);
                    } else {
                        dp[i] = Math.min(dp[i], costs[1]);
                    }
                    if (i >= 30) {
                        dp[i] = Math.min(dp[i], costs[2] + dp[i - 30]);
                    } else {
                        dp[i] = Math.min(dp[i], costs[2]);
                    }
                } else {
                    dp[i] = dp[i - 1];
                }
            }
            return dp[days[days.length - 1]];
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(11, s.mincostTickets(new int[] {1, 4, 6, 7, 8, 20}, new int[] {2, 7, 15}));
        Assert.assertEquals(17,
            s.mincostTickets(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[] {2, 7, 15}));
        Assert.assertEquals(6, s.mincostTickets(new int[] {1, 4, 6, 7, 8, 20}, new int[] {7, 2, 15}));
    }


}

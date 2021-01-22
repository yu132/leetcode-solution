package redo.p1000_1099;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1049  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月19日  
 *  
 */
public class P1049 {

    static//

    class Solution {
        public int lastStoneWeightII(int[] stones) {
            int sum = sum(stones);
            int[] dp = new int[sum / 2 + 1];
            for (int i = 0; i < stones.length; ++i) {
                for (int j = sum / 2; j >= stones[i]; --j) {
                    dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
                }
            }
            return sum - 2 * dp[sum / 2];
        }

        public static int sum(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.lastStoneWeightII(new int[] {2, 7, 4, 1, 8, 1}));
        Assert.assertEquals(0, s.lastStoneWeightII(new int[] {1, 1}));
    }

}

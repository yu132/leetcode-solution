package redo.p0100_0199;

import java.util.List;

/**  
 * @ClassName: P120  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月1日  
 *  
 */
public class P120 {

    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[] dp = new int[n];
            dp[0] = triangle.get(0).get(0);
            for (int i = 1; i < n; ++i) {
                dp[i] = dp[i - 1] + triangle.get(i).get(i);
                for (int j = i - 1; j > 0; --j) {
                    dp[j] = Math.min(dp[i], dp[i - 1]) + triangle.get(i).get(j);
                }
                dp[0] += triangle.get(i).get(0);
            }
            int min = Integer.MAX_VALUE;
            for (int num : dp) {
                min = Math.min(min, num);
            }
            return min;
        }
    }

}

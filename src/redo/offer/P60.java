package redo.offer;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: P60  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P60 {

    class Solution {
        public double[] dicesProbability(int n) {
            double[][] dp = new double[2][5 * n + 1];
            dp[0][0] = 1;
            int scroll = 1;
            for (int i = 1; i <= n; ++i, scroll ^= 1) {
                double sum = 0;
                for (int j = 0; j < 5 * i + 1; ++j) {
                    sum += dp[scroll ^ 1][j];
                    if (j >= 6) {
                        sum -= dp[scroll ^ 1][j - 6];
                    }
                    dp[scroll][j] = sum / 6;
                }
            }
            return dp[scroll ^ 1];
        }
    }

}

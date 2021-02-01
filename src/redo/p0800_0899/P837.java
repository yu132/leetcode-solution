package redo.p0800_0899;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P837  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月30日  
 *  
 */
public class P837 {

    class Solution {
        public double new21Game(int N, int K, int W) {

            if (N - K + 1 >= W) {
                return 1.0;
            }

            double[] dp = new double[K + W];

            for (int i = K; i <= N; ++i) {// 大于N的范围就不再需要填
                dp[i] = 1.0;
            }

            double range = N - K + 1;// 长度为W范围内的概率总和

            for (int i = K - 1; i >= 0; --i) {
                dp[i] = range / W;// 1/W的概率抽取到[i+1,i+W]中的任何一个概率
                range += dp[i] - dp[i + W];// 更新区间
            }

            return dp[0];
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1.0, s.new21Game(10, 1, 10), 0.00001);
        Assert.assertEquals(0.6, s.new21Game(6, 1, 10), 0.00001);
        Assert.assertEquals(0.73278, s.new21Game(21, 17, 10), 0.00001);
        Assert.assertEquals(1, s.new21Game(1, 0, 1), 0.00001);

    }

}

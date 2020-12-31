package redo.LCP;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: LCP22  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月30日  
 *  
 */
public class LCP22 {

    class Solution {
        public int paintingPlan(int n, int k) {
            if (n * n == k) {
                return 1;
            }
            int ans = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (i * n + j * n - i * j == k) {
                        ans += combinatorialNumber(i, n) * combinatorialNumber(j, n);
                    }
                }
            }
            return ans;
        }

        public int combinatorialNumber(int m, int n) {
            return factorial(n) / (factorial(n - m) * factorial(m));
        }

        public int factorial(int num) {
            int n = 1;
            for (int i = 2; i <= num; ++i) {
                n *= i;
            }
            return n;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.paintingPlan(2, 2));
        Assert.assertEquals(0, s.paintingPlan(2, 1));
        Assert.assertEquals(1, s.paintingPlan(2, 4));
        Assert.assertEquals(4, s.paintingPlan(2, 3));
        Assert.assertEquals(9, s.paintingPlan(3, 8));
    }

}

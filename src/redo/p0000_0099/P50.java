package redo.p0000_0099;

/**  
 * @ClassName: P50  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月4日  
 *  
 */
public class P50 {

    class Solution {
        public double myPow(double x, int n) {
            long N = n;
            if (N < 0) {
                x = 1 / x;
                N = -N;
            }
            return fastPow(x, N);
        }

        public double fastPow(double base, long exp) {
            double ans = 1;
            while (exp > 0) {
                if ((exp & 1) == 1) {
                    ans *= base;
                }
                exp >>= 1;
                base *= base;
            }
            return ans;
        }
    }

}

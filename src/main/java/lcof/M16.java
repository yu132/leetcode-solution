package lcof;

/**  
 * @ClassName: M16  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月14日  
 *  
 */
public class M16 {

    class Solution {
        public double myPow(double x, int n) {
            double num = 1;
            long   N   = n;
            if (n < 0) {
                N = -N;
                x = 1 / x;
            }
            while (N > 0) {
                if (N % 2 == 1) {
                    num *= x;
                }
                N >>= 1;
                x   = x * x;
            }
            return num;
        }
    }

}

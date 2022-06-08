package redo.p0000_0099;

/**  
 * @ClassName: P29  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月11日  
 *  
 */
public class P29 {

    class Solution {
        public int divide(int dividend, int divisor) {
            long d1 = dividend, d2 = divisor;
            boolean sign = d1 < 0 ^ d2 < 0;
            d1 = Math.abs(d1);
            d2 = Math.abs(d2);

            long low = 1, high = d1 + 1;

            while (low < high) {
                long mid = (low + high) >>> 1;
                if (mid * d2 <= d1) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            long ret = (low - 1) * (sign ? -1 : 1);

            if (ret > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            return (int)ret;
        }
    }

}

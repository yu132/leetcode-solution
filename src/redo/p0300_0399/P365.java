package redo.p0300_0399;

import java.util.Arrays;

/**  
 * @ClassName: P365  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月15日  
 *  
 */
public class P365 {

    class Solution {
        public boolean canMeasureWater(int x, int y, int z) {

            if (x + y < z) {
                return false;
            }

            if (x == 0 || y == 0) {
                return z == 0 || (x + y == z);
            }

            return z % gcd(x, y) == 0;
        }

        int gcd(int m, int n) {
            int r = m % n;
            while (r != 0) {
                m = n;
                n = r;
                r = m % n;
            }
            return n;
        }
    }

}

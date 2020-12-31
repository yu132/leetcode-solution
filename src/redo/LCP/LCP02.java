package redo.LCP;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: LCP02  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月30日  
 *  
 */
public class LCP02 {

    class Solution {
        public int[] fraction(int[] cont) {
            int top = 0, low = 1;
            for (int i = cont.length - 1; i >= 0; --i) {
                top += low * cont[i];
                int gcd = gcd(top, low);
                top /= gcd;
                low /= gcd;
                int temp = low;
                low = top;
                top = temp;
            }
            return new int[] {low, top};
        }

        public int gcd(int m, int n) {
            int r;
            while (n > 0) {
                r = m % n;
                m = n;
                n = r;
            }
            return m;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {13, 4}, s.fraction(new int[] {3, 2, 0, 2}));
        Assert.assertArrayEquals(new int[] {3, 1}, s.fraction(new int[] {0, 0, 3}));
    }

}

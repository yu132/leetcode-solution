package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1323  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月28日  
 *  
 */
public class P1323 {

    class Solution {
        public int maximum69Number(int num) {
            int base = 0, index = 1, n = num;
            while (n != 0) {
                if (n % 10 == 6) {
                    base = index;
                }
                ++index;
                n /= 10;
            }
            if (base == 0) {
                return num;
            }
            int pow = 1;
            for (int i = 0; i < base - 1; ++i) {
                pow *= 10;
            }
            return num + 3 * pow;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(9969, s.maximum69Number(9669));
        Assert.assertEquals(9999, s.maximum69Number(9969));
        Assert.assertEquals(9999, s.maximum69Number(9999));
        Assert.assertEquals(9999, s.maximum69Number(9996));
    }

}

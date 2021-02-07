package redo.offer;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P44  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P44 {

    static//

    class Solution {

        public int findNthDigit(int n) {

            --n;

            int base = 1;
            long batch = 9;

            while (n >= batch * base) {
                n -= batch * base;
                ++base;
                batch = batch * 10;
            }

            int first = (int)Math.pow(10, base - 1);

            int num = first + n / base;

            n %= base;

            int diff = base - n - 1;

            while (diff-- != 0) {
                num /= 10;
            }

            return num % 10;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.findNthDigit(3));
        Assert.assertEquals(0, s.findNthDigit(11));
        Assert.assertEquals(1, s.findNthDigit(10));
        Assert.assertEquals(0, s.findNthDigit(496889));
        Assert.assertEquals(1, s.findNthDigit(1000000000));
    }

}

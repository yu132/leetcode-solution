package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1556  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1556 {

    class Solution {
        public String thousandSeparator(int n) {
            if (n == 0) {
                return "0";
            }
            StringBuilder buf = new StringBuilder();
            int digits = 0;
            while (n != 0) {
                buf.append(n % 10);
                n /= 10;
                ++digits;
                if (digits % 3 == 0 && n != 0) {
                    buf.append(".");
                }
            }
            return buf.reverse().toString();
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("987", s.thousandSeparator(987));
        Assert.assertEquals("1.234", s.thousandSeparator(1234));
        Assert.assertEquals("123.456.789", s.thousandSeparator(123456789));
        Assert.assertEquals("0", s.thousandSeparator(0));
    }

}

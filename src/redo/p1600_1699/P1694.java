package redo.p1600_1699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1694  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月30日  
 *  
 */
public class P1694 {

    class Solution {
        public String reformatNumber(String number) {
            int num = 0, in = 0;
            for (char ch : number.toCharArray()) {
                if (Character.isDigit(ch)) {
                    ++num;
                }
            }
            StringBuilder buf = new StringBuilder(number.length() * 2);
            for (char ch : number.toCharArray()) {
                if (Character.isDigit(ch)) {
                    buf.append(ch);
                    ++in;
                    if (in == 2 && num == 4) {
                        buf.append('-');
                        in = 0;
                        num = 2;
                    } else if (in == 3 && num != 3) {
                        buf.append('-');
                        in = 0;
                        num -= 3;
                    }
                }
            }
            return buf.toString();
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("123-456", s.reformatNumber("1-23-45 6"));
        Assert.assertEquals("123-45-67", s.reformatNumber("123 4-567"));
        Assert.assertEquals("123-456-78", s.reformatNumber("123 4-5678"));
        Assert.assertEquals("12", s.reformatNumber("12"));
        Assert.assertEquals("175-229-353-94-75", s.reformatNumber("--17-5 229 35-39475 "));
    }

}

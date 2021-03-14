package redo.Util.math;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: StringIntCul  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月14日  
 *  
 */
public class StringIntCul {

    String sum(String num1, String num2) {
        StringBuilder buf =
            new StringBuilder(Math.max(num1.length(), num2.length()));

        int inc = 0, index = 0;

        for (; index < num1.length() || index < num2.length() || inc != 0;
            ++index) {

            int val = get(num1, index) + get(num2, index) + inc;
            inc = val / 10;
            buf.append(val % 10);
        }

        return buf.reverse().toString();
    }

    int get(String num, int index) {
        if (index >= num.length()) {
            return 0;
        }
        return num.charAt(num.length() - 1 - index) - '0';
    }



    @Test
    public void test() {
        StringIntCul s = new StringIntCul();
        Assert.assertEquals("2468", s.sum("123", "2345"));
    }

}

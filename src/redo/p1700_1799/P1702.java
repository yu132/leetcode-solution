package redo.p1700_1799;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1702  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月31日  
 *  
 */
public class P1702 {

    class Solution {
        public String maximumBinaryString(String binary) {
            int count1 = 0;
            for (char ch : binary.toCharArray()) {
                if (ch == '1') {
                    ++count1;
                }
            }
            if (count1 == binary.length() || count1 == binary.length() - 1) {
                return binary;
            }
            return repeat('1', binary.length() - 1 - count1) + "0" + repeat('1', count1);
        }

        public String repeat(char ch, int times) {
            StringBuilder buf = new StringBuilder(times);
            for (int i = 0; i < times; ++i) {
                buf.append(ch);
            }
            return buf.toString();
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("111011", s.maximumBinaryString("000110"));
        Assert.assertEquals("01", s.maximumBinaryString("01"));
        Assert.assertEquals("11", s.maximumBinaryString("11"));
        Assert.assertEquals("10", s.maximumBinaryString("10"));
        Assert.assertEquals("101", s.maximumBinaryString("100"));
        Assert.assertEquals("11111111110111111111", s.maximumBinaryString("01111001100000110010"));
    }

}

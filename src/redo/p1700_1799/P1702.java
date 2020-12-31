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
            char[] chs = binary.toCharArray();
            for (char ch : chs) {
                if (ch == '1') {
                    ++count1;
                }
            }
            if (count1 == binary.length() || count1 == binary.length() - 1) {
                return binary;
            }
            for (int i = 0; i < binary.length() - 1 - count1; ++i) {
                chs[i] = '1';
            }
            chs[binary.length() - 1 - count1] = '0';
            for (int i = binary.length() - count1; i < chs.length; ++i) {
                chs[i] = '1';
            }
            return String.valueOf(chs);
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

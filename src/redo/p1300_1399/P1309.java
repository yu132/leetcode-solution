package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1309  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月28日  
 *  
 */
public class P1309 {

    class Solution {
        public String freqAlphabets(String s) {
            StringBuilder buf = new StringBuilder(s.length());
            for (int i = s.length() - 1; i >= 0; --i) {
                if (s.charAt(i) == '#') {
                    int n = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
                    buf.append(mapping(n));
                    i -= 2;
                } else {
                    buf.append(mapping(s.charAt(i) - '0'));
                }
            }
            return buf.reverse().toString();
        }

        private char mapping(int num) {
            return (char)(num + 'a' - 1);
        }
    }


    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("jkab", s.freqAlphabets("10#11#12"));
        Assert.assertEquals("acz", s.freqAlphabets("1326#"));
        Assert.assertEquals("y", s.freqAlphabets("25#"));
        Assert.assertEquals("abcdefghijklmnopqrstuvwxyz",
            s.freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
    }

}

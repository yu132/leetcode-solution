package redo.p1400_1499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1417  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1417 {

    class Solution {
        public String reformat(String s) {
            int num = 0, letter = 0;
            for (char ch : s.toCharArray()) {
                if (Character.isLetter(ch)) {
                    ++letter;
                } else {
                    ++num;
                }
            }
            if (Math.abs(num - letter) > 1) {
                return "";
            }
            char[] chs = new char[s.length()];

            int indexNum, indexLetter;
            if (num >= letter) {
                indexNum = 0;
                indexLetter = 1;
            } else {
                indexNum = 1;
                indexLetter = 0;
            }
            for (char ch : s.toCharArray()) {
                if (Character.isDigit(ch)) {
                    chs[indexNum] = ch;
                    indexNum += 2;
                } else {
                    chs[indexLetter] = ch;
                    indexLetter += 2;
                }
            }

            return String.valueOf(chs);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("0a1b2c", s.reformat("a0b1c2"));
        Assert.assertEquals("", s.reformat("leetcode"));
        Assert.assertEquals("", s.reformat("1229857369"));
        Assert.assertEquals("c2o0v1i9d", s.reformat("covid2019"));
        Assert.assertEquals("1a2b3", s.reformat("ab123"));
    }
}

package redo.p1700_1799;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1790  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月28日  
 *  
 */
public class P1790 {

    class Solution {
        public boolean areAlmostEqual(String s1, String s2) {

            if (s1.length() != s2.length()) {
                return false;
            }

            char ch11, ch12, ch21, ch22;
            ch11 = ch12 = ch21 = ch22 = '\0';

            for (int i = 0; i < s1.length(); ++i) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    if (ch11 == '\0') {
                        ch11 = s1.charAt(i);
                        ch21 = s2.charAt(i);
                    } else if (ch12 == '\0') {
                        ch12 = s1.charAt(i);
                        ch22 = s2.charAt(i);
                    } else {
                        return false;
                    }
                }
            }

            return ch11 == ch22 && ch12 == ch21;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.areAlmostEqual("bank", "kanb"));
    }
}

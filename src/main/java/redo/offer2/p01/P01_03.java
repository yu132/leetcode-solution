package redo.offer2.p01;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P01_03  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P01_03 {

    class Solution {
        public String replaceSpaces(String S, int length) {
            char[] ch = S.toCharArray();
            int i = length - 1, j = ch.length - 1;
            for (; i >= 0; --i) {
                if (ch[i] != ' ') {
                    ch[j--] = ch[i];
                } else {
                    ch[j--] = '0';
                    ch[j--] = '2';
                    ch[j--] = '%';
                }
            }
            return String.valueOf(ch, j + 1, ch.length - j - 1);
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("ds%20sdfs%20afs%20sdfa%20dfssf%20asdf",
            s.replaceSpaces("ds sdfs afs sdfa dfssf asdf             ", 27));
    }

}

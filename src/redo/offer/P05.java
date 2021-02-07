package redo.offer;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P05  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月2日  
 *  
 */
public class P05 {

    class Solution {
        public String replaceSpace(String s) {
            StringBuilder buf = new StringBuilder(s.length());
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == ' ') {
                    buf.append('%').append('2').append('0');
                } else {
                    buf.append(s.charAt(i));
                }
            }
            return buf.toString();
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("We%20are%20happy.",
            s.replaceSpace("We are happy."));
    }

}

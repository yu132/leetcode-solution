package redo.p1100_1199;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1108  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月27日  
 *  
 */
public class P1108 {

    class Solution {
        public String defangIPaddr(String address) {
            StringBuilder buf = new StringBuilder(address.length() + 6);
            for (char ch : address.toCharArray()) {
                if (ch == '.') {
                    buf.append("[.]");
                } else {
                    buf.append(ch);
                }
            }
            return buf.toString();
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("1[.]1[.]1[.]1", s.defangIPaddr("1.1.1.1"));
        Assert.assertEquals("255[.]100[.]50[.]0", s.defangIPaddr("255.100.50.0"));
    }

}

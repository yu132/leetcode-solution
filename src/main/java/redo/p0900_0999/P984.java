package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P984  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月20日  
 *  
 */
public class P984 {

    class Solution {
        public String strWithout3a3b(int a, int b) {
            StringBuilder buf = new StringBuilder(a + b);
            boolean aturn = a >= b;
            while (a > 0 || b > 0) {
                if (aturn) {
                    if (a >= 2 && a > b) {
                        buf.append('a').append('a');
                        a -= 2;
                    } else {
                        buf.append('a');
                        --a;
                    }
                } else {
                    if (b >= 2 && b > a) {
                        buf.append('b').append('b');
                        b -= 2;
                    } else {
                        buf.append('b');
                        --b;
                    }
                }
                aturn = !aturn;
            }
            return buf.toString();
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("bba", s.strWithout3a3b(1, 2));
        Assert.assertEquals("aabaa", s.strWithout3a3b(4, 1));
    }

}

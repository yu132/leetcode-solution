package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1374  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1374 {

    class Solution {
        public String generateTheString(int n) {
            if (n % 2 == 0) {
                return 'b' + repeat('a', n - 1);
            }
            return repeat('a', n);
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
        Assert.assertEquals("baaa", s.generateTheString(4));
        Assert.assertEquals("aaa", s.generateTheString(3));
    }

}

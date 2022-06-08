package redo.p0600_0699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P696  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P696 {

    class Solution {
        public int countBinarySubstrings(String s) {
            int c0 = 0, c1 = 0, ans = 0;

            boolean is0 = false;
            for (char ch : s.toCharArray()) {
                if (ch == '0') {
                    if (is0) {
                        ++c0;
                    } else {
                        c0 = 1;
                        is0 = true;
                    }
                    if (c0 <= c1) {
                        ++ans;
                    }
                } else {
                    if (!is0) {
                        ++c1;
                    } else {
                        c1 = 1;
                        is0 = false;
                    }
                    if (c1 <= c0) {
                        ++ans;
                    }
                }
            }
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(6, s.countBinarySubstrings("00110011"));
        Assert.assertEquals(4, s.countBinarySubstrings("10101"));
        Assert.assertEquals(1, s.countBinarySubstrings("1111110"));
        Assert.assertEquals(2, s.countBinarySubstrings("00111111"));
        Assert.assertEquals(2, s.countBinarySubstrings("11011"));
        Assert.assertEquals(2, s.countBinarySubstrings("00100"));

    }

}

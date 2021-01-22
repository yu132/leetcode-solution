package redo.p1200_1299;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1247  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月12日  
 *  
 */
public class P1247 {

    class Solution {
        public int minimumSwap(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return -1;
            }
            int xy = 0, yx = 0;
            for (int i = 0; i < s1.length(); ++i) {
                char ch1 = s1.charAt(i), ch2 = s2.charAt(i);
                if (ch1 == 'x' && ch2 == 'y') {
                    ++xy;
                } else if (ch1 == 'y' && ch2 == 'x') {
                    ++yx;
                }
            }
            if ((xy + yx) % 2 != 0) {
                return -1;
            }

            if (xy % 2 == 0) {
                return xy / 2 + yx / 2;
            } else {
                --xy;
                ++yx;
                return xy / 2 + yx / 2 + 1;
            }

        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.minimumSwap("xy", "yx"));
        Assert.assertEquals(-1, s.minimumSwap("xx", "xy"));
        Assert.assertEquals(4, s.minimumSwap("xxyyxyxyxx", "xyyxyxxxyx"));
    }

}

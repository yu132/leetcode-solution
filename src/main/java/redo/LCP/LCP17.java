package redo.LCP;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: LCP17  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月30日  
 *  
 */
public class LCP17 {

    class Solution {
        public int calculate(String s) {
            int x = 1, y = 0;
            for (char ch : s.toCharArray()) {
                if (ch == 'A') {
                    x = 2 * x + y;
                } else {
                    y = 2 * y + x;
                }
            }
            return x + y;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.calculate("AB"));
    }

}

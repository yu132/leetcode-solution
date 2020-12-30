package redo.p0600_0699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P657  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P657 {

    class Solution {
        public boolean judgeCircle(String moves) {
            int x = 0, y = 0;
            for (char ch : moves.toCharArray()) {
                switch (ch) {
                    case 'R':
                        ++y;
                        break;
                    case 'L':
                        --y;
                        break;
                    case 'U':
                        ++x;
                        break;
                    case 'D':
                        --x;
                        break;
                }
            }
            return x == 0 && y == 0;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.judgeCircle("UD"));
        Assert.assertEquals(false, s.judgeCircle("LL"));
    }

}

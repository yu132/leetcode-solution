package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1318  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月10日  
 *  
 */
public class P1318 {

    class Solution {
        public int minFlips(int a, int b, int c) {
            int count = 0;
            while (a != 0 || b != 0 || c != 0) {
                int x = a & 1, y = b & 1, z = c & 1;
                if (z == 1) {
                    if (x == 0 && y == 0) {
                        ++count;
                    }
                } else { // z==0
                    if (x == 1) {
                        ++count;
                    }
                    if (y == 1) {
                        ++count;
                    }
                }
                a >>= 1;
                b >>= 1;
                c >>= 1;
            }
            return count;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.minFlips(2, 6, 5));
        Assert.assertEquals(1, s.minFlips(4, 2, 7));
        Assert.assertEquals(0, s.minFlips(1, 2, 3));
    }

}

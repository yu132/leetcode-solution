package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P991  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月20日  
 *  
 */
public class P991 {

    class Solution {
        public int brokenCalc(int X, int Y) {
            int count = 0;
            while (Y != X) {
                if (Y > X) {
                    if (Y % 2 != 0) {
                        ++count;
                        ++Y;
                    }
                    Y /= 2;
                    ++count;
                } else {
                    return X - Y + count;
                }
            }
            return count;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.brokenCalc(2, 3));
        Assert.assertEquals(2, s.brokenCalc(5, 8));
        Assert.assertEquals(3, s.brokenCalc(3, 10));
        Assert.assertEquals(1023, s.brokenCalc(1024, 1));
    }

}

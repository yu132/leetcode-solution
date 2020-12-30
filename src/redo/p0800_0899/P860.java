package redo.p0800_0899;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P860  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月22日  
 *  
 */
public class P860 {

    class Solution {
        public boolean lemonadeChange(int[] bills) {
            int c5 = 0, c10 = 0;
            for (int num : bills) {
                if (num == 5) {
                    ++c5;
                } else if (num == 10) {
                    ++c10;
                    --c5;
                } else {
                    if (c10 >= 1) {
                        --c10;
                        --c5;
                    } else {
                        c5 -= 3;
                    }
                }

                if (c5 < 0 || c10 < 0) {
                    return false;
                }
            }
            return true;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.lemonadeChange(new int[] {5, 5, 5, 10, 20}));
        Assert.assertEquals(true, s.lemonadeChange(new int[] {5, 5, 10}));
        Assert.assertEquals(false, s.lemonadeChange(new int[] {10, 10}));
        Assert.assertEquals(false, s.lemonadeChange(new int[] {5, 5, 10, 10, 20}));
        Assert.assertEquals(true, s.lemonadeChange(new int[] {5, 5, 10, 20}));
    }

}

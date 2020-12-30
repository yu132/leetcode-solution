package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1550  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1550 {

    class Solution {
        public boolean threeConsecutiveOdds(int[] arr) {
            int odd = 0;
            for (int i = 0; i < arr.length; ++i) {
                if (arr[i] % 2 != 0) {
                    ++odd;
                    if (odd == 3) {
                        return true;
                    }
                } else {
                    odd = 0;
                }
            }
            return false;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(false, s.threeConsecutiveOdds(new int[] {2, 6, 4, 1}));
        Assert.assertEquals(true, s.threeConsecutiveOdds(new int[] {1, 2, 34, 3, 4, 5, 7, 23, 12}));
        Assert.assertEquals(true, s.threeConsecutiveOdds(new int[] {2, 3, 5, 7}));
    }

}

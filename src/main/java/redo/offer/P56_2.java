package redo.offer;

import org.junit.Assert;
import org.junit.Test;
import redo.Util.Bits;

/**  
 * @ClassName: P56_2  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P56_2 {

    class Solution {

        /*
         * num a b a b
         * 0   0 0 0 0
         * 1   0 0 1 0
         * 0   1 0 1 0
         * 0   0 1 0 1
         * 
         * 1   1 0 0 1
         * 1   0 1 0 0
         * 
         * 0   1 1 0 0 x
         * 1   1 1 1 0 x
         */

        public int singleNumber(int[] nums) {
            int a = 0, b = 0;

            for (int num : nums) {
                // int t = a ^ num & ~b;
                // b = (a & num) | (b & ~(a | num));
                // a = t;
                a = a ^ num & ~b;
                b = b ^ num & ~a;
            }
            return a;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.singleNumber(new int[] {9, 9, 7, 7, 7, 9}));
    }

}

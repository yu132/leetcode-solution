package redo.offer2.p05;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P05_03  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月9日  
 *  
 */
public class P05_03 {

    class Solution {
        public int reverseBits(int num) {
            if (num == -1) {
                return 32;
            }
            int reverse = ~num, max = 0;
            while (reverse != 0) {
                max =
                    Math.max(max, maxLen1(num | Integer.lowestOneBit(reverse)));
                reverse &= reverse - 1;
            }
            return max;
        }

        public int maxLen1(int num) {
            int len = 0, max = 0;
            while (num != 0) {
                if ((num & 1) == 1) {
                    ++len;
                } else {
                    max = Math.max(max, len);
                    len = 0;
                }
                num >>>= 1;
            }
            return Math.max(max, len);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(8, s.reverseBits(1775));
        Assert.assertEquals(4, s.reverseBits(7));
    }
}

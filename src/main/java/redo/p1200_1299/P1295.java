package redo.p1200_1299;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1295  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月28日  
 *  
 */
public class P1295 {

    class Solution {
        public int findNumbers(int[] nums) {
            int ans = 0;
            for (int num : nums) {
                int digits = 0;
                while (num != 0) {
                    ++digits;
                    num /= 10;
                }
                if (digits % 2 == 0) {
                    ++ans;
                }
            }
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.findNumbers(new int[] {12, 345, 2, 6, 7896}));
        Assert.assertEquals(1, s.findNumbers(new int[] {555, 901, 482, 1771}));
    }

}

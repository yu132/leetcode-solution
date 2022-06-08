package redo.p1400_1499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1464  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1464 {

    class Solution {
        public int maxProduct(int[] nums) {
            int max = 1, max2 = 1;
            for (int num : nums) {
                if (num > max) {
                    max2 = max;
                    max = num;
                } else if (num > max2) {
                    max2 = num;
                }
            }
            return (max - 1) * (max2 - 1);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(12, s.maxProduct(new int[] {3, 4, 5, 2}));
        Assert.assertEquals(16, s.maxProduct(new int[] {1, 5, 4, 5}));
        Assert.assertEquals(12, s.maxProduct(new int[] {3, 7}));
    }

}

package redo.p1400_1499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1437  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月8日  
 *  
 */
public class P1437 {

    class Solution {
        public boolean kLengthApart(int[] nums, int k) {
            int margin = k;
            for (int num : nums) {
                if (num == 1) {
                    if (margin < k) {
                        return false;
                    }
                    margin = 0;
                } else {
                    ++margin;
                }
            }
            return true;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.kLengthApart(new int[] {1, 0, 0, 0, 1, 0, 0, 1}, 2));
        Assert.assertEquals(false, s.kLengthApart(new int[] {1, 0, 0, 1, 0, 1}, 2));
        Assert.assertEquals(false, s.kLengthApart(new int[] {1, 1, 1, 1, 1}, 2));
        Assert.assertEquals(true, s.kLengthApart(new int[] {0, 1, 0, 1}, 1));
    }

}

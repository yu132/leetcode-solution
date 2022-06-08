package redo.p0700_0799;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P724  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P724 {

    class Solution {
        public int pivotIndex(int[] nums) {
            if (nums.length == 0) {
                return -1;
            }
            if (nums.length == 1) {
                return 0;
            }

            int windowL = 0, windowR = 0, pre = 0;
            for (int i = 0; i < nums.length; ++i) {
                windowR += nums[i];
            }
            for (int i = 0; i < nums.length; ++i) {
                windowR -= nums[i];
                windowL += pre;
                pre = nums[i];
                if (windowL == windowR) {
                    return i;
                }
            }
            return -1;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.pivotIndex(new int[] {1, 7, 3, 6, 5, 6}));
        Assert.assertEquals(-1, s.pivotIndex(new int[] {1, 2, 3}));
        Assert.assertEquals(2, s.pivotIndex(new int[] {0, 0, 1000000}));
    }

}

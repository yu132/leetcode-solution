package redo.p0600_0699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P665  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P665 {

    class Solution {
        public boolean checkPossibility(int[] nums) {
            if (nums.length == 1) {
                return true;
            }
            if (nums.length < 2) {
                return nums[0] <= nums[1];
            }
            if (nums[0] > nums[1]) {
                for (int i = 2; i < nums.length; ++i) {
                    if (nums[i - 1] > nums[i]) {
                        return false;
                    }
                }
            }

            boolean fix = false;
            for (int i = 2; i < nums.length; ++i) {
                if (nums[i - 2] > nums[i]) {
                    if (fix) {
                        return false;
                    }
                    nums[i] = nums[i - 1];
                    fix = true;
                } else if (nums[i - 1] > nums[i]) {
                    if (fix) {
                        return false;
                    }
                    nums[i - 1] = nums[i];
                    fix = true;
                }
            }

            return true;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.checkPossibility(new int[] {4, 2, 3}));
        Assert.assertEquals(false, s.checkPossibility(new int[] {4, 2, 1}));
        Assert.assertEquals(false, s.checkPossibility(new int[] {4, 4, 1, 1}));
        Assert.assertEquals(true, s.checkPossibility(new int[] {1, 2, 2, 3}));
        Assert.assertEquals(true, s.checkPossibility(new int[] {1, 2, 2, 2, 3}));
        Assert.assertEquals(false, s.checkPossibility(new int[] {3, 4, 2, 3}));
        Assert.assertEquals(true, s.checkPossibility(new int[] {5, 7, 1, 8}));
    }

}

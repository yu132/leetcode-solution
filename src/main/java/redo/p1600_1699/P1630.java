package redo.p1600_1699;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1630  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月3日  
 *  
 */
public class P1630 {

    class Solution {
        public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
            List<Boolean> ans = new ArrayList<>(l.length);
            for (int i = 0; i < l.length; ++i) {
                int[] subArr = Arrays.copyOfRange(nums, l[i], r[i] + 1);
                ans.add(isArithmeticSequence(subArr));
            }
            return ans;
        }

        public boolean isArithmeticSequence(int[] nums) {
            if (nums.length <= 2) {
                return true;
            }
            Arrays.sort(nums);
            int diff = nums[1] - nums[0];
            for (int i = 2; i < nums.length; ++i) {
                if (nums[i] - nums[i - 1] != diff) {
                    return false;
                }
            }
            return true;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList(true, false, true),
            s.checkArithmeticSubarrays(new int[] {4, 6, 5, 9, 3, 7}, new int[] {0, 0, 2}, new int[] {2, 3, 5}));
        Assert.assertEquals(Arrays.asList(false, true, false, false, true, true),
            s.checkArithmeticSubarrays(new int[] {-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10},
                new int[] {0, 1, 6, 4, 8, 7}, new int[] {4, 4, 9, 7, 9, 10}));

    }

}

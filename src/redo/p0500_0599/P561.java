package redo.p0500_0599;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P561  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P561 {

    class Solution {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int sum = 0;
            for (int i = 0; i < nums.length; i += 2) {
                sum += nums[i];
            }
            return sum;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.arrayPairSum(new int[] {1, 4, 3, 2}));
        Assert.assertEquals(9, s.arrayPairSum(new int[] {6, 2, 6, 5, 1, 2}));
    }
}

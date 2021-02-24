package redo.p0100_0199;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P152  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月23日  
 *  
 */
public class P152 {

    class Solution {
        public int maxProduct(int[] nums) {
            int max = 1, min = 1, ans = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; ++i) {
                if (Double.compare(nums[i], 0.0) == 0) {
                    max = min = 1;
                    ans = Math.max(0, ans);
                    continue;
                }
                int lastMax = max, lastMin = min;
                max = Math.max(Math.max(lastMax * nums[i], lastMin * nums[i]),
                    nums[i]);
                min = Math.min(Math.min(lastMax * nums[i], lastMin * nums[i]),
                    nums[i]);
                ans = Math.max(max, ans);
            }
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(12, s.maxProduct(new int[] {-4, -3, -2}));
    }

}

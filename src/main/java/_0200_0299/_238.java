package _0200_0299;

import java.util.Arrays;

/**  
 * @ClassName: _238  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月29日  
 *  
 */
public class _238 {

    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] ans = new int[nums.length];
            Arrays.fill(ans, 1);
            int left = 1, right = 1;
            for (int i = 0; i < nums.length; ++i) {
                ans[i]                   *= left;
                left                     *= nums[i];

                ans[nums.length - 1 - i] *= right;
                right                    *= nums[nums.length - 1 - i];
            }

            return ans;
        }
    }

}

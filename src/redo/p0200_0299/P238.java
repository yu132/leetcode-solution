package redo.p0200_0299;

/**  
 * @ClassName: P238  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月14日  
 *  
 */
public class P238 {

    class Solution {
        public int[] productExceptSelf(int[] nums) {

            int[] ans = new int[nums.length];

            int product = 1;

            for (int i = 0; i < nums.length; ++i) {
                ans[i] = product;
                product *= nums[i];
            }

            product = 1;

            for (int i = nums.length - 1; i >= 0; --i) {
                ans[i] *= product;
                product *= nums[i];
            }

            return ans;
        }
    }

}

package _1400_1499;

/**  
 * @ClassName: _1464  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年6月6日  
 *  
 */
public class _1464 {

    class Solution {
        public int maxProduct(int[] nums) {
            int max1, max2;

            if (nums[0] >= nums[1]) {
                max1 = nums[0];
                max2 = nums[1];
            } else {
                max1 = nums[1];
                max2 = nums[0];
            }

            for (int i = 2; i < nums.length; ++i) {
                if (nums[i] > max1) {
                    max2 = max1;
                    max1 = nums[i];
                } else if (nums[i] > max2) {
                    max2 = nums[i];
                }
            }

            return (max1 - 1) * (max2 - 1);
        }
    }

}

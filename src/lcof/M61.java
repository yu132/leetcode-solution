package lcof;

import java.util.Arrays;

/**  
 * @ClassName: M61  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月24日  
 *  
 */
public class M61 {

    class Solution {
        public boolean isStraight(int[] nums) {

            Arrays.sort(nums);

            int c0 = 0;

            while (nums[c0] == 0) {
                ++c0;
            }

            for (int i = c0 + 1; i < nums.length; ++i) {
                if (nums[i - 1] == nums[i]) {
                    return false;
                }
                if (nums[i - 1] + 1 != nums[i]) {
                    c0 -= nums[i] - nums[i - 1] - 1;
                    if (c0 < 0) {
                        return false;
                    }
                }
            }

            return true;

        }
    }

}

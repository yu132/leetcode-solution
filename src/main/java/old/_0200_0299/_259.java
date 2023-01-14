package old._0200_0299;

import java.util.Arrays;

/**  
 * @ClassName: _259  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月8日  
 *  
 */
public class _259 {

    class Solution {
        public int threeSumSmaller(int[] nums, int target) {
            int ans = 0;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; ++i) {
                int l = i + 1, r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    if (sum >= target) {
                        --r;
                    } else {
                        ++l;
                        ans += r - 1;
                    }
                }
            }
            return ans;
        }
    }

}

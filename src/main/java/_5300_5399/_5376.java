package _5300_5399;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**  
 * @ClassName: _5376  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月5日  
 *  
 */
public class _5376 {

    class Solution {
        public List<Integer> minSubsequence(int[] nums) {
            int sum = 0, sumb = 0;
            for (int i = 0; i < nums.length; ++i) {
                sum += nums[i];
            }
            Arrays.sort(nums);
            for (int i = nums.length - 1; i >= 0; --i) {
                sumb += nums[i];
                sum  -= nums[i];
                if (sumb > sum) {
                    List<Integer> ans = new ArrayList<>();
                    for (int j = nums.length - 1; j >= i; --j) {
                        ans.add(nums[j]);
                    }
                    return ans;
                }
            }
            return null;
        }
    }

}

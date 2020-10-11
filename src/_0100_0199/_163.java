package _0100_0199;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: _163  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月16日  
 *  
 */
public class _163 {

    class Solution {
        public List<String> findMissingRanges(int[] nums, int lower, int upper) {
            List<String> ans = new ArrayList<>();
            if (nums.length == 0) {
                if (lower == upper) {
                    ans.add(String.valueOf(lower));
                } else {
                    ans.add(lower + "->" + upper);
                }
                return ans;
            }

            if (lower != nums[0]) {
                if (lower + 1 == nums[0]) {
                    ans.add(String.valueOf(lower));
                } else {
                    ans.add((lower) + "->" + (nums[0] - 1));
                }
            }

            for (int i = 1; i < nums.length; ++i) {
                if (nums[i - 1] != nums[i] && nums[i - 1] + 1 != nums[i]) {
                    if (nums[i - 1] + 2 == nums[i]) {
                        ans.add(String.valueOf(nums[i - 1] + 1));
                    } else {
                        ans.add((nums[i - 1] + 1) + "->" + (nums[i] - 1));
                    }
                }
            }

            if (nums[nums.length - 1] != upper) {
                if (nums[nums.length - 1] + 1 == upper) {
                    ans.add(String.valueOf(upper));
                } else {
                    ans.add((nums[nums.length - 1] + 1) + "->" + upper);
                }
            }
            return ans;
        }
    }

}

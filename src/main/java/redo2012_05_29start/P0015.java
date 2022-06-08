package redo2012_05_29start;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**  
 * @ClassName: P0015  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年5月30日  
 *  
 */
public class P0015 {

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {

            List<List<Integer>> ans = new ArrayList<>();

            Arrays.sort(nums);

            int n = nums.length;

            for (int i = 0; i < n - 2; ++i) {
                if (i != 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                if (nums[i] + nums[n - 2] + nums[n - 1] < 0) {
                    continue;
                }
                if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                    break;
                }
                int low = i + 1, high = n - 1;
                while (low < high) {
                    if (nums[i] + nums[low] + nums[high] < 0) {
                        ++low;
                    } else if (nums[i] + nums[low] + nums[high] > 0) {
                        --high;
                    } else {
                        ans.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        ++low;
                        while (low < high && nums[low] == nums[low - 1]) {
                            ++low;
                        }
                        --high;
                        while (low < high && nums[high] == nums[high + 1]) {
                            --high;
                        }
                    }
                }
            }

            return ans;
        }
    }

}

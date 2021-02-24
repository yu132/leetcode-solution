package redo.p0000_0099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**  
 * @ClassName: P18  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月21日  
 *  
 */
public class P18 {

    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {

            if (nums == null || nums.length < 4) {
                return Collections.emptyList();
            }

            List<List<Integer>> ans = new ArrayList<>();

            int n = nums.length;

            Arrays.sort(nums);

            for (int i = 0; i < n - 3; ++i) {

                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                if (nums[i] + nums[i + 1] + nums[i + 2]
                    + nums[i + 3] > target) {
                    break;
                }

                if (nums[i] + nums[n - 3] + nums[n - 2]
                    + nums[n - 1] < target) {
                    continue;
                }

                for (int j = i + 1; j < n - 2; ++j) {

                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }

                    if (nums[i] + nums[j] + nums[j + 1]
                        + nums[j + 2] > target) {
                        break;
                    }

                    if (nums[i] + nums[j] + nums[n - 2]
                        + nums[n - 1] < target) {
                        continue;
                    }


                    int low = j + 1, high = n - 1;

                    while (low < high) {
                        int val = nums[i] + nums[j] + nums[low] + nums[high];

                        if (val == target) {
                            ans.add(Arrays.asList(nums[i], nums[j], nums[low],
                                nums[high]));

                            while (low < high && nums[low] == nums[low + 1]) {
                                ++low;
                            }
                            ++low;

                            while (low < high && nums[high - 1] == nums[high]) {
                                --high;
                            }
                            --high;

                        } else if (val < target) {
                            ++low;
                        } else {
                            --high;
                        }
                    }
                }
            }
            return ans;
        }
    }

}

package reredo.rrrd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;

/**  
 * @ClassName: P15  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月25日  
 *  
 */
public class P15 {

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();

            Arrays.sort(nums);

            int n = nums.length;

            for (int i = 0; i < n - 2; ++i) {

                if (i != 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                    break;
                }

                if (nums[i] + nums[n - 2] + nums[n - 1] < 0) {
                    continue;
                }

                int low = i + 1, high = n - 1;

                while (low < high) {
                    int sum = nums[i] + nums[low] + nums[high];

                    boolean lowPlus1;
                    if (sum < 0) {
                        lowPlus1 = true;
                    } else if (sum > 0) {
                        lowPlus1 = false;
                    } else {
                        ans.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        lowPlus1 = true;
                    }
                    if (lowPlus1) {
                        while (low < high && nums[low] == nums[low + 1]) {
                            ++low;
                        }
                        ++low;
                    } else {
                        while (low < high && nums[high] == nums[high - 1]) {
                            --high;
                        }
                        --high;
                    }
                }
            }
            return ans;
        }
    }

}

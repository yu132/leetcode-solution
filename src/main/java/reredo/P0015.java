package reredo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**  
 * @ClassName: P15  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月2日  
 *  
 */
public class P0015 {

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();

            Arrays.sort(nums);

            int n = nums.length;

            for (int i = 0; i < n; ++i) {
                if (i != 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int num1 = nums[i];
                int low = i + 1, high = n - 1;
                while (low < high) {
                    int num2 = nums[low], num3 = nums[high];
                    int sum = num1 + num2 + num3;
                    if (sum == 0) {
                        ans.add(Arrays.asList(num1, num2, num3));

                        while (low < high && nums[low + 1] == nums[low]) {
                            ++low;
                        }
                        ++low;
                    } else if (sum > 0) {
                        while (low < high && nums[high - 1] == nums[high]) {
                            --high;
                        }
                        --high;
                    } else {
                        while (low < high && nums[low + 1] == nums[low]) {
                            ++low;
                        }
                        ++low;
                    }
                }
            }

            return ans;
        }
    }

}

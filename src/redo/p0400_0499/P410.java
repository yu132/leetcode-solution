package redo.p0400_0499;

/**  
 * @ClassName: P410  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月28日  
 *  
 */
public class P410 {

    class Solution {
        public int splitArray(int[] nums, int m) {

            int low = 0, high = sum(nums);

            while (low < high) {
                int mid = (low + high) >>> 1;
                if (check(nums, m, mid)) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            return low;
        }

        int sum(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }

        boolean check(int[] nums, int k, int part) {
            int sum = 0, count = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] > part) {
                    return false;
                }
                if (sum + nums[i] > part) {
                    sum = 0;
                    ++count;
                }
                sum += nums[i];
            }
            if (sum > 0) {
                ++count;
            }
            return count <= k;
        }
    }

}

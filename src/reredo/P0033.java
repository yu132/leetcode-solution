package reredo;

/**  
 * @ClassName: P0033  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月3日  
 *  
 */
public class P0033 {

    class Solution {
        public int search(int[] nums, int target) {
            int minIndex = searchMin(nums);
            int ret = lowerBound(nums, 0, minIndex, target);
            if (ret != -1) {
                return ret;
            }
            return lowerBound(nums, minIndex, nums.length, target);
        }

        int lowerBound(int[] nums, int low, int high, int target) {
            if (low >= high) {
                return -1;
            }
            int end = high;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (target <= nums[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            if (low == end || nums[low] != target) {
                return -1;
            }
            return low;
        }

        int searchMin(int[] nums) {
            int low = 0, high = nums.length - 1;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (nums[mid] > nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }

}

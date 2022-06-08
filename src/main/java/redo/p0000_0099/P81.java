package redo.p0000_0099;

/**  
 * @ClassName: P81  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月13日  
 *  
 */
public class P81 {

    class Solution {
        public boolean search(int[] nums, int target) {

            int minIndex = searchMin(nums);

            int ret = binarySearch(nums, target, 0, minIndex);

            if (ret != -1) {
                return true;
            }

            return binarySearch(nums, target, minIndex, nums.length) != -1;
        }

        int binarySearch(int[] nums, int target, int low, int high) {
            int index = lowerBound(nums, target, low, high);
            if (index == high || nums[index] != target) {
                return -1;
            }
            return index;
        }

        int lowerBound(int[] nums, int target, int low, int high) {
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (target <= nums[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        int searchMin(int[] nums) {
            int low = 0, high = nums.length - 1;

            while (low < high) {
                int mid = (low + high) >>> 1;

                if (nums[mid] < nums[high]) {
                    high = mid;
                } else if (nums[mid] > nums[high]) {
                    low = mid + 1;
                } else {
                    if (nums[high - 1] > nums[high]) {
                        return high;
                    }
                    --high;
                }
            }

            return low;
        }
    }

}

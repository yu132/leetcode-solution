package redo2012_07_25start;

/**  
 * @ClassName: P215  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年7月25日  
 *  
 */
public class P215 {

    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return minK(nums, nums.length - k);
        }

        int minK(int[] nums, int K) {
            int low = 0, high = nums.length - 1;
            int mid;
            do {
                mid = partition(nums, low, high);
                if (mid < K) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            } while (mid != K);
            return nums[mid];
        }

        int partition(int[] nums, int low, int high) {
            if (low >= high) {
                return low;
            }
            int pivot = nums[low];
            while (low < high) {
                while (low < high && nums[high] >= pivot) {
                    --high;
                }
                nums[low] = nums[high];
                while (low < high && nums[low] <= pivot) {
                    ++low;
                }
                nums[high] = nums[low];
            }
            nums[low] = pivot;
            return low;
        }
    }

}

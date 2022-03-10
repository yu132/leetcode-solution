package redo2012_07_25start;

/**  
 * @ClassName: P912  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年7月26日  
 *  
 */
public class P912 {

    class Solution {
        public int[] sortArray(int[] nums) {
            qsort(nums, 0, nums.length);
            return nums;
        }

        void qsort(int[] nums, int low, int high) {
            if (low >= high) {
                return;
            }
            int mid = partiton(nums, low, high);
            qsort(nums, low, mid);
            qsort(nums, mid + 1, high);
        }

        int partiton(int[] nums, int low, int high) {
            if (low >= high) {
                return low;
            }
            --high;
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

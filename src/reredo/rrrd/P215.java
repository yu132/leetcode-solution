package reredo.rrrd;

import java.util.concurrent.ThreadLocalRandom;

import javax.management.RuntimeErrorException;

/**  
 * @ClassName: P215  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月25日  
 *  
 */
public class P215 {

    class Solution {
        public int findKthLargest(int[] nums, int k) {

            int kIndex = nums.length - k;

            int low = 0, high = nums.length - 1;

            while (low < high) {
                int mid = randomPartition(nums, low, high);
                if (mid > kIndex) {
                    high = mid - 1;
                } else if (mid < kIndex) {
                    low = mid + 1;
                } else {
                    return nums[mid];
                }
            }

            return nums[low];
        }

        int randomPartition(int[] nums, int low, int high) {
            ThreadLocalRandom r = ThreadLocalRandom.current();
            int index = r.nextInt(high - low) + low;
            swap(nums, low, index);
            return partition(nums, low, high);
        }

        int partition(int[] nums, int low, int high) {
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

        void swap(int[] arr, int x, int y) {
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }
    }

}

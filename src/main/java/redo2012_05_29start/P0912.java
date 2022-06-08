package redo2012_05_29start;

import java.util.concurrent.ThreadLocalRandom;

/**  
 * @ClassName: P0912  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年5月29日  
 *  
 */
public class P0912 {

    class Solution {
        public int[] sortArray(int[] nums) {
            rQsort(nums, 0, nums.length);
            return nums;
        }

        void rQsort(int[] nums, int low, int high) {
            if (low + 1 >= high) {
                return;
            }
            ThreadLocalRandom r = ThreadLocalRandom.current();
            int index = r.nextInt(high - low) + low;
            swap(nums, low, index);
            int mid = partition(nums, low, high);
            rQsort(nums, low, mid);
            rQsort(nums, mid + 1, high);
        }

        int partition(int[] nums, int low, int high) {
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

        void swap(int[] nums, int x, int y) {
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
        }


    }

}

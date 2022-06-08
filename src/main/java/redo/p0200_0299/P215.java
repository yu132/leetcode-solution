package redo.p0200_0299;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P215  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月23日  
 *  
 */
public class P215 {

    class Solution {

        ThreadLocalRandom r = ThreadLocalRandom.current();

        public int findKthLargest(int[] nums, int k) {
            k = nums.length - k;
            int low = 0, high = nums.length - 1, mid;
            do {
                mid = rPartition(nums, low, high);
                if (mid >= k) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            } while (mid != k);
            return nums[k];
        }

        int rPartition(int[] nums, int low, int high) {
            if (low >= high) {
                return low;
            }
            int index = r.nextInt(high + 1 - low) + low;
            int temp = nums[low];
            nums[low] = nums[index];
            nums[index] = temp;
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
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(5,
            s.findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 2));
    }
}

package redo2012_05_29start;

import java.util.Arrays;

/**  
 * @ClassName: P0031  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年6月5日  
 *  
 */
public class P0031 {

    class Solution {
        public void nextPermutation(int[] nums) {
            int index = nums.length - 2;
            while (index >= 0 && nums[index] >= nums[index + 1]) {
                --index;
            }
            if (index == -1) {
                reverse(nums, 0, nums.length);
                return;
            }
            int indexUpper =
                binSreach(nums, index + 1, nums.length, nums[index]);
            swap(nums, index, indexUpper);
            reverse(nums, index + 1, nums.length);
        }

        int binSreach(int[] nums, int low, int high, int target) {
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (nums[mid] > target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low - 1;
        }

        void reverse(int[] nums, int low, int high) {
            --high;
            while (low < high) {
                swap(nums, low++, high--);
            }
        }

        void swap(int[] nums, int x, int y) {
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
        }
    }

}

package redo2012_05_29start;

/**  
 * @ClassName: P0033  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年6月5日  
 *  
 */
public class P0033 {

    class Solution {
        public int search(int[] nums, int target) {
            int mid = searchMid(nums);
            int ans = lowerBound(nums, target, 0, mid);
            if (ans != -1) {
                return ans;
            }
            return lowerBound(nums, target, mid, nums.length);
        }

        int searchMid(int[] nums) {
            int low = 0, high = nums.length;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (nums[mid] > nums[nums.length - 1]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }

        int lowerBound(int[] nums, int target, int low, int high) {
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            if (low < nums.length && nums[low] == target) {
                return low;
            }
            return -1;
        }
    }

}

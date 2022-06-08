package redo.offer;

/**  
 * @ClassName: P53  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P53_1 {

    class Solution {
        public int search(int[] nums, int target) {
            return upperBound(nums, target) - lowerBound(nums, target);
        }

        public int lowerBound(int[] nums, int target) {
            int low = 0, high = nums.length;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }

        public int upperBound(int[] nums, int target) {
            int low = 0, high = nums.length;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (nums[mid] <= target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }

}

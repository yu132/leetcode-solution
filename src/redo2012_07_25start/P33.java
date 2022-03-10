package redo2012_07_25start;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P33  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年8月8日  
 *  
 */
public class P33 {

    static//

    class Solution {
        public int search(int[] nums, int target) {

            int mid = bound(nums, 0, nums.length);

            int val = binSearch(nums, 0, mid, target);

            if (-1 != val) {
                return val;
            }

            return binSearch(nums, mid, nums.length, target);
        }

        int bound(int[] nums, int low, int high) {
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

        int binSearch(int[] nums, int low, int high, int target) {
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            if (low == nums.length || nums[low] != target) {
                return -1;
            }
            return low;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().search(Arrs.build("[3,1]"), 1));
    }

}

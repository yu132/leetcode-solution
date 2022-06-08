package redo.p0000_0099;

/**  
 * @ClassName: P33  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月4日  
 *  
 */
public class P33 {

    class Solution {
        public int search(int[] nums, int target) {
            int mid = minValueIndex(nums);
            int lowIndex = binarySearch(nums, 0, mid, target);
            if (lowIndex != -1) {
                return lowIndex;
            }
            int highIndex = binarySearch(nums, mid, nums.length, target);
            if (highIndex != -1) {
                return highIndex;
            }
            return -1;
        }

        public int minValueIndex(int[] a) {
            int low = 0, high = a.length - 1;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (a[mid] < a[high]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        public int binarySearch(int[] a, int low, int high, int target) {
            int index = lowerBound(a, low, high, target);
            if (index == high || a[index] != target) {
                return -1;
            }
            return index;
        }

        public int lowerBound(int[] a, int low, int high, int target) {
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (a[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }

}

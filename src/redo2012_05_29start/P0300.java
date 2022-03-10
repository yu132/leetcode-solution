package redo2012_05_29start;

/**  
 * @ClassName: P300  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年6月5日  
 *  
 */
public class P0300 {

    class Solution {
        public int lengthOfLIS(int[] nums) {

            int[] stack = new int[nums.length];

            int index = 0;

            for (int num : nums) {
                int insertIndex = binSearch(stack, 0, index, num);
                stack[insertIndex] = num;
                if (insertIndex == index) {
                    ++index;
                }
            }

            return index;
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
            return low;
        }
    }

}

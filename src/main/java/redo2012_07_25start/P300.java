package redo2012_07_25start;

import java.util.Arrays;

/**  
 * @ClassName: P300  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年8月8日  
 *  
 */
public class P300 {

    class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] arr = new int[nums.length];

            int index = -1;
            for (int num : nums) {
                if (index == -1 || num > arr[index]) {
                    arr[++index] = num;
                } else {
                    int i = lowerBound(arr, 0, index, num);
                    arr[i] = num;
                }
            }
            return index;
        }

        int lowerBound(int[] arr, int low, int high, int target) {
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }

}

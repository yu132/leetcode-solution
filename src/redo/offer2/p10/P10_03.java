package redo.offer2.p10;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P10_03  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月11日  
 *  
 */
public class P10_03 {

    class Solution {
        public int search(int[] arr, int target) {
            int bound = findBound(arr);
            int index = lowerBound(arr, target, 0, bound);
            if (arr[index] == target) {
                return index;
            }
            index = lowerBound(arr, target, bound, arr.length);
            if (index != arr.length && arr[index] == target) {
                return index;
            }
            return -1;
        }

        public int lowerBound(int[] arr, int target, int low, int high) {
            if (low >= high) {
                return low;
            }
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (target <= arr[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        public int findBound(int[] arr) {
            int low = 0, high = arr.length - 1;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (arr[mid] == arr[high]) {
                    --high;
                } else if (arr[mid] > arr[high]) {
                    low = mid + 1;
                } else {
                    if (high + 1 < arr.length && arr[high + 1] < arr[high]) {
                        return high + 1;
                    }
                    high = mid;
                }
            }
            return low;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        // Assert.assertEquals(8,
        // s.search(new int[] {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}, 5));
        Assert.assertEquals(5,
            s.search(new int[] {1, 1, 1, 1, 1, 2, 1, 1, 1}, 2));

    }


}

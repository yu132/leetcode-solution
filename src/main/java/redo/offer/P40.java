package redo.offer;

import java.util.Arrays;

/**  
 * @ClassName: P40  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P40 {

    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            int low = 0, high = arr.length - 1;
            while (true) {
                int mid = partition(arr, low, high);
                if (mid == k || mid == k - 1) {
                    return Arrays.copyOf(arr, k);
                } else if (mid < k) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        public int partition(int[] arr, int low, int high) {
            int pivot = arr[low];
            while (low < high) {
                while (low < high && arr[high] >= pivot) {
                    --high;
                }
                arr[low] = arr[high];
                while (low < high && arr[low] <= pivot) {
                    ++low;
                }
                arr[high] = arr[low];
            }
            arr[low] = pivot;
            return low;
        }
    }

}

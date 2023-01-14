package redo.mianshi.p17;

import java.util.Arrays;

/**  
 * @ClassName: P17_14  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月16日  
 *  
 */
public class P17_14 {

    class Solution {
        public int[] smallestK(int[] arr, int k) {
            int low = 0, high = arr.length - 1, mid;
            do {
                mid = partition(arr, low, high);
                if (mid < k) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } while (mid != k && mid != k - 1);
            return Arrays.copyOf(arr, k);
        }

        public int partition(int[] arr, int low, int high) {
            if (low >= high) {
                return low;
            }
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

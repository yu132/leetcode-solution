package lcof;

import java.util.Arrays;

/**  
 * @ClassName: M40  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月19日  
 *  
 */
public class M40 {

    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {

            if (arr.length == 0) {
                return new int[0];
            }

            int low = 0, high = arr.length - 1;

            int pos = partition(arr, low, high);
            while (pos != k && pos != k - 1) {
                if (pos > k) {
                    high = pos - 1;
                } else {
                    low = pos + 1;
                }
                pos = partition(arr, low, high);
            }

            return Arrays.copyOfRange(arr, 0, k);
        }

        public int partition(int[] arr, int low, int high) {
            int temp = arr[low];
            while (low < high) {
                while (arr[high] >= temp && high > low) {
                    --high;
                }
                arr[low] = arr[high];
                while (arr[low] <= temp && low < high) {
                    ++low;
                }
                arr[high] = arr[low];
            }
            arr[high] = temp;
            return high;
        }
    }

}

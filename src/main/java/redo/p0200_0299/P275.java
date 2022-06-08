package redo.p0200_0299;

/**  
 * @ClassName: P275  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月14日  
 *  
 */
public class P275 {

    class Solution {
        public int hIndex(int[] citations) {
            return culIndexHeight(citations, peak(citations));
        }

        int peak(int[] arr) {
            int low = 0, high = arr.length;

            while (low < high) {
                int mid = (low + high) >>> 1;
                if (culIndexHeight(arr, mid) <= culIndexHeight(arr, mid + 1)) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            return low;
        }

        int culIndexHeight(int[] arr, int index) {
            if (index == arr.length) {
                return 0;
            }
            return Math.min(arr[index], arr.length - index);
        }
    }

}

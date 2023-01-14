package old._1000_1099;

/**  
 * @ClassName: _1064  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月30日  
 *  
 */
public class _1064 {

    class Solution {
        public int fixedPoint(int[] A) {

            int low = 0, high = A.length - 1;

            while (low < high) {
                int mid = (low + high) >>> 1;
                if (A[mid] == mid) {
                    high = mid;
                } else if (A[mid] > mid) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            return A[low] == low ? low : -1;
        }
    }

}

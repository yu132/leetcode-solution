package redo.p0600_0699;

/**  
 * @ClassName: P668  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月25日  
 *  
 */
public class P668 {

    class Solution {
        public int findKthNumber(int m, int n, int k) {
            int low = 1, high = m * n;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (enough(mid, m, n, k)) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        boolean enough(int x, int m, int n, int k) {
            int count = 0;
            for (int i = 1; i <= m; ++i) {
                count += Math.min(x / i, n);
            }
            return count >= k;
        }
    }

}

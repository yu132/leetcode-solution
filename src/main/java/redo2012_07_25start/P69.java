package redo2012_07_25start;

/**  
 * @ClassName: P69  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年8月8日  
 *  
 */
public class P69 {

    class Solution {
        public int mySqrt(int x) {
            int low = 0, high = x / 2 + 6;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if ((long)mid * mid <= x) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low - 1;
        }
    }

}

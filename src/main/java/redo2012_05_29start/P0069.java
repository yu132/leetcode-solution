package redo2012_05_29start;

/**  
 * @ClassName: P0069  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年6月6日  
 *  
 */
public class P0069 {

    class Solution {
        public int mySqrt(int x) {

            int low = 0, high = x / 2 + 2;

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

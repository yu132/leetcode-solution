package reredo;

/**  
 * @ClassName: P0069  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月3日  
 *  
 */
public class P0069 {

    class Solution {
        public int mySqrt(int x) {
            long low = 0, high = (long)x + 1;
            while (low < high) {
                long mid = (low + high) >>> 1;
                if (mid * mid > x) {
                    high = (int)mid;
                } else {
                    low = (int)(mid + 1);
                }
            }
            return (int)(low - 1);
        }
    }

}

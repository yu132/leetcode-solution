package redo.offer2.p17;

/**  
 * @ClassName: P17_06  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月15日  
 *  
 */
public class P17_06 {

    class Solution {
        public int numberOf2sInRange(int n) {
            long base = 1;
            int high = n / 10, mid = n % 10, low = 0, ans = 0;
            while (high != 0 || mid != 0) {
                if (mid < 2) {
                    ans += high * base;
                } else if (mid == 2) {
                    ans += high * base + low + 1;
                } else {
                    ans += (high + 1) * base;
                }
                low += mid * base;
                mid = high % 10;
                high /= 10;
                base *= 10;
            }
            return ans;
        }

    }

}

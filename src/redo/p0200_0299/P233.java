package redo.p0200_0299;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P233  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P233 {

    class Solution {
        public int countDigitOne(int n) {
            long base = 1;
            int high = n / 10, mid = n % 10, low = 0, ans = 0;
            while (high != 0 || mid != 0) {
                if (mid == 0) {
                    ans += high * base;
                } else if (mid == 1) {
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



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(6, s.countDigitOne(13));
        Assert.assertEquals(44361922, s.countDigitOne(48915264));
    }

}

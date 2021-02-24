package redo.p0300_0399;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P367  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月23日  
 *  
 */
public class P367 {

    class Solution {
        public boolean isPerfectSquare(int num) {
            int low = 0, high = 46340;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (mid * mid < num) {
                    low = mid + 1;
                } else if (mid * mid > num) {
                    high = mid;
                } else {
                    return true;
                }
            }
            return false;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.isPerfectSquare(9));
    }

}

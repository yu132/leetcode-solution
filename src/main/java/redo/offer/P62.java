package redo.offer;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P62  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P62 {

    static//

    class Solution {
        public int lastRemaining(int n, int m) {
            int f = 0;
            for (int i = 2; i <= n; ++i) {
                f = (m + f) % i;
            }
            return f;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.lastRemaining(5, 3));
    }

}

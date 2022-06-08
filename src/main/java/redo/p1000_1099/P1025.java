package redo.p1000_1099;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1025  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月26日  
 *  
 */
public class P1025 {

    class Solution {
        public boolean divisorGame(int N) {
            return (N & 1) == 0;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.divisorGame(2));
        Assert.assertEquals(false, s.divisorGame(3));
    }

}

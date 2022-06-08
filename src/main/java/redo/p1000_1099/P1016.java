package redo.p1000_1099;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1016  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月19日  
 *  
 */
public class P1016 {

    class Solution {
        public boolean queryString(String S, int N) {
            for (int i = N / 2 + 1; i <= N; ++i) {
                if (!S.contains(Integer.toBinaryString(i))) {
                    return false;
                }
            }
            return true;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.queryString("0110", 3));
        Assert.assertEquals(false, s.queryString("0110", 4));
        Assert.assertEquals(false, s.queryString("110101011011000011011111000000", 15));
    }

}

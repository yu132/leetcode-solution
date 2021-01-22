package redo.p1000_1099;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1006  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月20日  
 *  
 */
public class P1006 {

    class Solution {
        public int clumsy(int N) {
            switch (N) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 6;
                case 4:
                    return 7;

                default:
                    switch (N % 4) {
                        case 1:
                            return N + 2;
                        case 2:
                            return N + 2;
                        case 3:
                            return N - 1;
                        case 0:
                            return N + 1;
                    }
            }

            throw new RuntimeException("unreachable");
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(7, s.clumsy(4));
        Assert.assertEquals(12, s.clumsy(10));
    }

}

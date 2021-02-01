package redo.p0800_0899;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P858  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月28日  
 *  
 */
public class P858 {

    class Solution {
        public int mirrorReflection(int p, int q) {
            while ((p & 1) == 0 && (q & 1) == 0) {
                p >>= 1;
                q >>= 1;
            }
            if ((p & 1) == 0) {
                return 2;
            }
            if ((q & 1) == 0) {
                return 0;
            }
            return 1;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.mirrorReflection(2, 1));
    }

}

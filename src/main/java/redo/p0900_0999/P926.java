package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P926  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月25日  
 *  
 */
public class P926 {

    class Solution {
        public int minFlipsMonoIncr(String S) {
            int l1 = 0, r0 = 0;
            for (char ch : S.toCharArray()) {
                if (ch == '0') {
                    ++r0;
                }
            }
            int min = r0;
            for (char ch : S.toCharArray()) {
                if (ch == '0') {
                    --r0;
                } else {
                    ++l1;
                }
                min = Math.min(min, l1 + r0);
            }
            return min;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.minFlipsMonoIncr("00110"));
        Assert.assertEquals(2, s.minFlipsMonoIncr("010110"));
        Assert.assertEquals(2, s.minFlipsMonoIncr("00011000"));
    }

}

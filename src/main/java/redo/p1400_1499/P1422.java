package redo.p1400_1499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1422  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1422 {

    class Solution {
        public int maxScore(String s) {
            int n1 = 0, n0 = 0, max = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '1') {
                    ++n1;
                }
            }
            for (int i = 0; i < s.length() - 1; ++i) {
                if (s.charAt(i) == '0') {
                    ++n0;
                } else {
                    --n1;
                }
                max = Math.max(max, n0 + n1);
            }
            return max;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(5, s.maxScore("011101"));
        Assert.assertEquals(5, s.maxScore("00111"));
        Assert.assertEquals(3, s.maxScore("1111"));
        Assert.assertEquals(3, s.maxScore("0000"));
    }

}

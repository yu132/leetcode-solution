package redo.p1000_1099;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1014  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月19日  
 *  
 */
public class P1014 {

    class Solution {
        public int maxScoreSightseeingPair(int[] A) {
            int p = A[0], max = 0;
            for (int i = 1; i < A.length; ++i) {
                --p;
                max = Math.max(max, p + A[i]);
                p = Math.max(p, A[i]);
            }
            return max;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(11, s.maxScoreSightseeingPair(new int[] {8, 1, 5, 2, 6}));
    }

}

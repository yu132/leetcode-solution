package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P908  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月24日  
 *  
 */
public class P908 {

    class Solution {
        public int smallestRangeI(int[] A, int K) {
            if (A.length <= 1) {
                return 0;
            }
            int min = A[0], max = A[0];
            for (int i = 1; i < A.length; ++i) {
                min = Math.min(min, A[i]);
                max = Math.max(max, A[i]);
            }
            int dif = max - min - 2 * K;

            return dif <= 0 ? 0 : dif;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(0, s.smallestRangeI(new int[] {1}, 0));
        Assert.assertEquals(6, s.smallestRangeI(new int[] {0, 10}, 2));
        Assert.assertEquals(0, s.smallestRangeI(new int[] {1, 3, 6}, 3));
    }

}

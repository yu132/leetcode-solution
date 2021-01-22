package redo.p1000_1099;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1007  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月20日  
 *  
 */
public class P1007 {

    class Solution {
        public int minDominoRotations(int[] A, int[] B) {
            int[] cA = new int[7], cB = new int[7], cAll = new int[7];

            for (int i = 0; i < A.length; ++i) {
                ++cA[A[i]];
                ++cB[B[i]];
                if (A[i] == B[i]) {
                    ++cAll[A[i]];
                }
            }

            for (int i = 1; i <= 6; ++i) {
                if (cA[i] + cB[i] - cAll[i] == A.length) {
                    return Math.min(cA[i], cB[i]) - cAll[i];
                }
            }

            return -1;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.minDominoRotations(new int[] {2, 1, 2, 4, 2, 2}, new int[] {5, 2, 6, 2, 3, 2}));
        Assert.assertEquals(-1, s.minDominoRotations(new int[] {3, 5, 1, 2, 3}, new int[] {3, 6, 3, 3, 4}));
    }

}

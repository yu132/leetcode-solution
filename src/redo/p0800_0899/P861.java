package redo.p0800_0899;

import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.Arrs;

/**  
 * @ClassName: P861  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月28日  
 *  
 */
public class P861 {

    /*
     * 1111
     * 1001
     * 1111
     * 
     */

    class Solution {
        public int matrixScore(int[][] A) {
            for (int i = 0; i < A.length; ++i) {
                if (A[i][0] == 0) {
                    reverse(A[i]);
                }
            }

            int ans = 0;

            for (int j = 0; j < A[0].length; ++j) {
                int c0 = 0, c1 = 0;
                for (int i = 0; i < A.length; ++i) {
                    if (A[i][j] == 0) {
                        ++c0;
                    } else {
                        ++c1;
                    }
                }
                ans = (ans << 1) + Math.max(c0, c1);
            }

            return ans;
        }

        public void reverse(int[] arr) {
            for (int i = 0; i < arr.length; ++i) {
                arr[i] ^= 1;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(39, s.matrixScore(Arrs.build2D("[[0,0,1,1],[1,0,1,0],[1,1,0,0]]")));
    }

}

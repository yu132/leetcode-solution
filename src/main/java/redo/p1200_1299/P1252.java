package redo.p1200_1299;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1252  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月28日  
 *  
 */
public class P1252 {

    class Solution {
        public int oddCells(int n, int m, int[][] indices) {
            int[] x = new int[n];
            int[] y = new int[m];
            for (int[] indice : indices) {
                ++x[indice[0]];
                ++y[indice[1]];
            }
            int ans = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if ((x[i] + y[j]) % 2 == 1) {
                        ++ans;
                    }
                }
            }
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(6, s.oddCells(2, 3, Arrs.build2D("[[0,1],[1,1]]")));
        Assert.assertEquals(0, s.oddCells(2, 2, Arrs.build2D("[[1,1],[0,0]]")));
    }

}

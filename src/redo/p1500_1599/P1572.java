package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1572  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1572 {

    class Solution {
        public int diagonalSum(int[][] mat) {
            int count = 0;
            for (int i = 0; i < mat.length; ++i) {
                count += mat[i][i];
                count += mat[i][mat.length - 1 - i];
            }
            if (mat.length % 2 != 0) {
                count -= mat[mat.length / 2][mat.length / 2];
            }
            return count;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(25, s.diagonalSum(Arrs.build2D("[[1,2,3],[4,5,6],[7,8,9]]")));
        Assert.assertEquals(8, s.diagonalSum(Arrs.build2D("[[1,1,1,1],[1,1,1,1],[1,1,1,1],[1,1,1,1]]")));
    }

}

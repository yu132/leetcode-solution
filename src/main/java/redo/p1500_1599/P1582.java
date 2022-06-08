package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1582  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月30日  
 *  
 */
public class P1582 {

    static//

    class Solution {
        public int numSpecial(int[][] mat) {
            if (mat.length == 0) {
                return 0;
            }
            int[] row = new int[mat.length], col = new int[mat[0].length];
            countRowAndColumn(mat, row, col);

            int count = 0;
            for (int i = 0; i < mat.length; ++i) {
                for (int j = 0; j < mat[0].length; ++j) {
                    if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) {
                        ++count;
                    }
                }
            }

            return count;
        }

        public static void countRowAndColumn(int[][] matrix, int[] row, int[] col) {
            for (int i = 0; i < matrix.length; ++i) {
                for (int j = 0; j < matrix[0].length; ++j) {
                    row[i] += matrix[i][j];
                    col[j] += matrix[i][j];
                }
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.numSpecial(Arrs.build2D("[[1,0,0],[0,0,1],[1,0,0]]")));
        Assert.assertEquals(3, s.numSpecial(Arrs.build2D("[[1,0,0],[0,1,0],[0,0,1]]")));
        Assert.assertEquals(2, s.numSpecial(Arrs.build2D("[[0,0,0,1],[1,0,0,0],[0,1,1,0],[0,0,0,0]]")));
        Assert.assertEquals(3,
            s.numSpecial(Arrs.build2D("[[0,0,0,0,0],[1,0,0,0,0],[0,1,0,0,0],[0,0,1,0,0],[0,0,0,1,1]]")));
    }

}

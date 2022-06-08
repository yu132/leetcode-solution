package redo.p0700_0799;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P766  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P766 {

    class Solution {
        public boolean isToeplitzMatrix(int[][] matrix) {
            for (int i = 0; i < matrix.length - 1; ++i) {
                int x = i + 1, y = 1, num = matrix[i][0];
                while (x < matrix.length && y < matrix[0].length) {
                    if (num != matrix[x][y]) {
                        return false;
                    }
                    ++x;
                    ++y;
                }
            }
            for (int i = 0; i < matrix[0].length - 1; ++i) {
                int x = 1, y = i + 1, num = matrix[0][i];
                while (x < matrix.length && y < matrix[0].length) {
                    if (num != matrix[x][y]) {
                        return false;
                    }
                    ++x;
                    ++y;
                }
            }
            return true;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.isToeplitzMatrix(new int[][] {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}}));
        Assert.assertEquals(false, s.isToeplitzMatrix(new int[][] {{1, 2}, {2, 2}}));
    }

}

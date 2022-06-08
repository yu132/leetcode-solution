package redo.p1200_1299;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1267  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月12日  
 *  
 */
public class P1267 {

    static//

    class Solution {
        public int countServers(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[] row = new int[m], col = new int[n];
            countRowAndColumn(grid, row, col);
            int count = sum(row);
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == 1 && row[i] == 1 && col[j] == 1) {
                        --count;
                    }
                }
            }
            return count;
        }

        public static int sum(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return sum;
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
        Assert.assertEquals(0, s.countServers(Arrs.build2D("[[1,0],[0,1]]")));
        Assert.assertEquals(3, s.countServers(Arrs.build2D("[[1,0],[1,1]]")));
        Assert.assertEquals(4, s.countServers(Arrs.build2D("[[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]")));
    }

}

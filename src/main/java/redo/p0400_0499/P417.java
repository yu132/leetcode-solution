package redo.p0400_0499;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.Arrs;

/**  
 * @ClassName: P417  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月16日  
 *  
 */
public class P417 {

    class Solution {
        public List<List<Integer>> pacificAtlantic(int[][] matrix) {

            if (matrix.length == 0 || matrix[0].length == 0) {
                return Collections.emptyList();
            }

            int m = matrix.length, n = matrix[0].length;

            int[][] dp = new int[m][n];

            for (int i = 0; i < m; ++i) {
                dp[i][0] |= 1;
            }

            for (int j = 0; j < n; ++j) {
                dp[0][j] |= 1;
            }

            for (int i = 0; i < m; ++i) {
                dp[i][n - 1] |= 2;
            }

            for (int j = 0; j < n; ++j) {
                dp[m - 1][j] |= 2;
            }

            List<List<Integer>> list = new ArrayList<>();

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (dp[i][j] != 0) {
                        dfs(i, j, m, n, -1, 0, matrix, dp);
                    }
                }
            }

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (dp[i][j] == 3) {
                        list.add(Arrays.asList(i, j));
                    }
                }
            }

            return list;
        }

        void dfs(int x, int y, int m, int n, int last, int paint,
            int[][] matrix, int[][] dp) {

            if (x < 0 || x >= m || y < 0 || y >= n) {
                return;
            }
            if ((dp[x][y] ^ paint) == 0) {
                return;
            }
            if (matrix[x][y] < last) {
                return;
            }
            dp[x][y] |= paint;
            dfs(x + 1, y, m, n, matrix[x][y], dp[x][y], matrix, dp);
            dfs(x - 1, y, m, n, matrix[x][y], dp[x][y], matrix, dp);
            dfs(x, y + 1, m, n, matrix[x][y], dp[x][y], matrix, dp);
            dfs(x, y - 1, m, n, matrix[x][y], dp[x][y], matrix, dp);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(
            Arrs.build2DL("[[0,2],[1,0],[1,1],[1,2],[2,0],[2,1],[2,2]]"),
            s.pacificAtlantic(Arrs.build2D("[[1,2,3],[8,9,4],[7,6,5]]")));
    }
}

package redo.offer2.p17;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.Arrs;

/**  
 * @ClassName: P17_23  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月19日  
 *  
 */
public class P17_23 {

    static//

    class Solution {
        public int[] findSquare(int[][] matrix) {

            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return new int[0];
            }

            int m = matrix.length, n = matrix[0].length;

            int[][][] dp = new int[m + 1][n + 1][2];

            for (int i = 1; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (matrix[i - 1][j - 1] == 0) {
                        dp[i][j][0] = 1 + dp[i - 1][j][0];
                        dp[i][j][1] = 1 + dp[i][j - 1][1];
                    }
                }
            }

            int maxX = 0, maxY = 0, maxWidth = 0;

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    for (int width = maxWidth + 1; width <= Math.min(i, j) + 1;
                        ++width) {
                        if (check(i, j, width, dp)) {
                            maxWidth = width;
                            maxX = i;
                            maxY = j;
                        }
                    }
                }
            }

            if (maxWidth == 0) {
                return new int[0];
            }

            return new int[] {maxX - maxWidth + 1, maxY - maxWidth + 1,
                maxWidth};
        }

        boolean check(int x, int y, int width, int[][][] dp) {
            if (dp[x + 1][y + 1][0] < width || dp[x + 1][y + 1][1] < width) {
                return false;
            }

            if (dp[x + 1 - width + 1][y + 1][1] < width
                || dp[x + 1][y + 1 - width + 1][0] < width) {
                return false;
            }

            return true;
        }

        static class Data {
            int width;
            int height;

            public Data(int width, int height) {
                super();
                this.width = width;
                this.height = height;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {1, 0, 2},
            s.findSquare(Arrs.build2D("[[1,0,1],[0,0,1],[0,0,1]]")));
    }

}

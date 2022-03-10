package redo2012_05_29start;

/**  
 * @ClassName: P200  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年6月5日  
 *  
 */
public class P0200 {

    class Solution {
        public int numIslands(char[][] grid) {
            int ans = 0;
            int m = grid.length, n = grid[0].length;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == '1') {
                        paint(i, j, '1', '2', grid, m, n);
                        ++ans;
                    }
                }
            }
            return ans;
        }

        void paint(int i, int j, char toPaint, char paintTo, char[][] grid,
            int m, int n) {
            if (i < 0 || i >= m || j < 0 || j >= n) {
                return;
            }
            if (grid[i][j] != toPaint) {
                return;
            }
            grid[i][j] = paintTo;
            paint(i + 1, j, toPaint, paintTo, grid, m, n);
            paint(i - 1, j, toPaint, paintTo, grid, m, n);
            paint(i, j + 1, toPaint, paintTo, grid, m, n);
            paint(i, j - 1, toPaint, paintTo, grid, m, n);
        }
    }

}

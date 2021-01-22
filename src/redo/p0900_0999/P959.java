package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P959  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月21日  
 *  
 */
public class P959 {

    class Solution {
        public int regionsBySlashes(String[] grid) {
            int m = grid.length, n = grid[0].length();
            boolean[][][] visited = new boolean[m][n][2];
            int count = 0;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (!visited[i][j][0]) {
                        ++count;
                        dfs(i, j, m, n, 0, visited, grid);
                    }
                    if (!visited[i][j][1]) {
                        ++count;
                        dfs(i, j, m, n, 1, visited, grid);
                    }
                }
            }
            return count;
        }

        // from 0 up, 1 down, 2 left, 3 right
        public void dfs(int x, int y, int m, int n, int from, boolean[][][] visited, String[] grid) {
            if (x < 0 || x >= m || y < 0 || y >= n) {
                return;
            }
            char ch = grid[x].charAt(y);
            if (ch == ' ') {
                if (visited[x][y][0]) {
                    return;
                }

                visited[x][y][0] = true;
                visited[x][y][1] = true;

                dfs(x - 1, y, m, n, 1, visited, grid);
                dfs(x + 1, y, m, n, 0, visited, grid);
                dfs(x, y - 1, m, n, 3, visited, grid);
                dfs(x, y + 1, m, n, 2, visited, grid);
            } else if (ch == '/') {
                if (from == 0 || from == 2) {
                    if (visited[x][y][0]) {
                        return;
                    }
                    visited[x][y][0] = true;
                    dfs(x - 1, y, m, n, 1, visited, grid);
                    dfs(x, y - 1, m, n, 3, visited, grid);
                } else {
                    if (visited[x][y][1]) {
                        return;
                    }
                    visited[x][y][1] = true;
                    dfs(x + 1, y, m, n, 0, visited, grid);
                    dfs(x, y + 1, m, n, 2, visited, grid);
                }
            } else {
                if (from == 0 || from == 3) {
                    if (visited[x][y][0]) {
                        return;
                    }
                    visited[x][y][0] = true;
                    dfs(x - 1, y, m, n, 1, visited, grid);
                    dfs(x, y + 1, m, n, 2, visited, grid);
                } else {
                    if (visited[x][y][1]) {
                        return;
                    }
                    visited[x][y][1] = true;
                    dfs(x + 1, y, m, n, 0, visited, grid);
                    dfs(x, y - 1, m, n, 3, visited, grid);
                }
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.regionsBySlashes(new String[] {" /", "/ "}));
        Assert.assertEquals(1, s.regionsBySlashes(new String[] {" /", "  "}));
        Assert.assertEquals(4, s.regionsBySlashes(new String[] {"\\/", "/\\"}));
        Assert.assertEquals(5, s.regionsBySlashes(new String[] {"/\\", "\\/"}));
        Assert.assertEquals(3, s.regionsBySlashes(new String[] {"//", "/ "}));
    }

}

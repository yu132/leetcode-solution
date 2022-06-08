package redo.p0400_0499;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P463  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P463 {

    class Solution {

        int num = 0;
        int next = 0;

        public int islandPerimeter(int[][] grid) {
            l:
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[0].length; ++j) {
                    if (grid[i][j] != 0) {
                        dfs(i, j, grid, new boolean[grid.length][grid[0].length]);
                        break l;
                    }
                }
            }

            return num * 4 - next * 2;
        }

        public void dfs(int x, int y, int[][] grid, boolean[][] visited) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] || grid[x][y] == 0) {
                return;
            }
            visited[x][y] = true;
            ++num;
            next += visited(x - 1, y, visited);
            next += visited(x + 1, y, visited);
            next += visited(x, y + 1, visited);
            next += visited(x, y - 1, visited);
            dfs(x + 1, y, grid, visited);
            dfs(x - 1, y, grid, visited);
            dfs(x, y + 1, grid, visited);
            dfs(x, y - 1, grid, visited);
        }

        public int visited(int x, int y, boolean[][] visited) {
            if (x < 0 || x >= visited.length || y < 0 || y >= visited[0].length) {
                return 0;
            }
            if (visited[x][y]) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(16, s.islandPerimeter(new int[][] {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}));
    }

}

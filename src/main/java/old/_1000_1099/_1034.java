package old._1000_1099;

import java.util.ArrayList;

/**  
 * @ClassName: _1034  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月4日  
 *  
 */
public class _1034 {

    class Solution {
        public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
            ArrayList<Pair> list = new ArrayList<>();
            dfs(r0, c0, new boolean[grid.length][grid[0].length], grid, list, grid[r0][c0]);

            for (Pair each : list) {
                grid[each.x][each.y] = color;
            }

            return grid;
        }

        public void dfs(int x, int y, boolean[][] visited, int[][] grid, ArrayList<Pair> list, int color) {
            if (x < 0 || y < 0 || x == grid.length || y == grid[0].length) {
                return;
            }
            if (visited[x][y]) {// 已经访问过
                return;
            }
            visited[x][y] = true;
            if (grid[x][y] != color) {// 不是联通分支内的块
                return;
            }

            // 是地图边缘或者连通分支边缘
            if (x == 0 || grid[x - 1][y] != color) {
                list.add(new Pair(x, y));
            } else if (y == 0 || grid[x][y - 1] != color) {
                list.add(new Pair(x, y));
            } else if (x == grid.length - 1 || grid[x + 1][y] != color) {
                list.add(new Pair(x, y));
            } else if (y == grid[0].length - 1 || grid[x][y + 1] != color) {
                list.add(new Pair(x, y));
            }

            dfs(x + 1, y, visited, grid, list, color);
            dfs(x - 1, y, visited, grid, list, color);
            dfs(x, y + 1, visited, grid, list, color);
            dfs(x, y - 1, visited, grid, list, color);
        }

        class Pair {
            int x;
            int y;

            public Pair(int x, int y) {
                super();
                this.x = x;
                this.y = y;
            }
        }
    }

}

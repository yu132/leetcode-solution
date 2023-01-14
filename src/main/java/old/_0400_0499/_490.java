package old._0400_0499;

/**  
 * @ClassName: _490  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月17日  
 *  
 */
public class _490 {

    class Solution {
        public boolean hasPath(int[][] maze, int[] start, int[] destination) {
            if (maze.length == 0) {
                return false;
            }
            return dfs(maze, new boolean[maze.length][maze[0].length], start[0], start[1], destination[0],
                destination[1]);
        }

        public boolean dfs(int[][] maze, boolean[][] visited, int x, int y, int tarX, int tarY) {
            if (x == tarX && y == tarY) {
                return true;
            }
            if (visited[x][y]) {
                return false;
            }
            visited[x][y] = true;

            int tempX = x, tempY = y;
            while (tempX > 0 && maze[tempX - 1][tempY] != 1) {
                --tempX;
            }
            if (dfs(maze, visited, tempX, tempY, tarX, tarY)) {
                return true;
            }

            tempX = x;
            tempY = y;
            while (tempX < maze.length - 1 && maze[tempX + 1][tempY] != 1) {
                ++tempX;
            }
            if (dfs(maze, visited, tempX, tempY, tarX, tarY)) {
                return true;
            }

            tempX = x;
            tempY = y;
            while (tempY > 0 && maze[tempX][tempY - 1] != 1) {
                --tempY;
            }
            if (dfs(maze, visited, tempX, tempY, tarX, tarY)) {
                return true;
            }

            tempX = x;
            tempY = y;
            while (tempY < maze[0].length - 1 && maze[tempX][tempY + 1] != 1) {
                ++tempY;
            }
            if (dfs(maze, visited, tempX, tempY, tarX, tarY)) {
                return true;
            }

            return false;
        }
    }

}

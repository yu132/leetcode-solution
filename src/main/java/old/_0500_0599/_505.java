package old._0500_0599;

/**  
 * @ClassName: _505  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月17日  
 *  
 */
public class _505 {

    class Solution {
        public int shortestDistance(int[][] maze, int[] start, int[] destination) {
            if (maze.length == 0) {
                return -1;
            }
            int[][] distacnce = new int[maze.length][maze[0].length];
            dfs(maze, distacnce, 0, start[0], start[1]);
            return distacnce[destination[0]][destination[1]] > 0 ? distacnce[destination[0]][destination[1]] : -1;
        }

        public void dfs(int[][] maze, int[][] distacnce, int dis, int x, int y) {
            if (distacnce[x][y] != 0 && distacnce[x][y] <= dis) {
                return;
            }
            distacnce[x][y] = dis;

            int tempX = x, tempY = y;
            while (tempX > 0 && maze[tempX - 1][tempY] != 1) {
                --tempX;
            }
            if (tempX != x || tempY != y) {
                dfs(maze, distacnce, dis + (x - tempX), tempX, tempY);
            }

            tempX = x;
            tempY = y;
            while (tempX < maze.length - 1 && maze[tempX + 1][tempY] != 1) {
                ++tempX;
            }
            if (tempX != x || tempY != y) {
                dfs(maze, distacnce, dis + (tempX - x), tempX, tempY);
            }

            tempX = x;
            tempY = y;
            while (tempY > 0 && maze[tempX][tempY - 1] != 1) {
                --tempY;
            }
            if (tempX != x || tempY != y) {
                dfs(maze, distacnce, dis + (y - tempY), tempX, tempY);
            }

            tempX = x;
            tempY = y;
            while (tempY < maze[0].length - 1 && maze[tempX][tempY + 1] != 1) {
                ++tempY;
            }

            if (tempX != x || tempY != y) {
                dfs(maze, distacnce, dis + (tempY - y), tempX, tempY);
            }
        }
    }

    public static void main(String[] args) {
        new _505().new Solution().shortestDistance(
            new int[][] {{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}},
            new int[] {0, 4}, new int[] {4, 4});
    }
}

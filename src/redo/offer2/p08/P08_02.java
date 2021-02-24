package redo.offer2.p08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**  
 * @ClassName: P08_02  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月10日  
 *  
 */
public class P08_02 {

    class Solution {
        public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {

            if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
                return Collections.emptyList();
            }

            int m = obstacleGrid.length, n = obstacleGrid[0].length;

            List<List<Integer>> ans = new ArrayList<>();

            backtrack(0, 0, m, n, obstacleGrid, ans, new boolean[m][n]);

            return ans;
        }

        public boolean backtrack(int x, int y, int m, int n,
            int[][] obstacleGrid, List<List<Integer>> road,
            boolean[][] visited) {

            if (x >= m || y >= n) {
                return false;
            }

            if (obstacleGrid[x][y] == 1) {
                return false;
            }

            if (visited[x][y]) {
                return false;
            }

            visited[x][y] = true;
            road.add(Arrays.asList(x, y));

            if (x == m - 1 && y == n - 1) {
                return true;
            }

            if (backtrack(x + 1, y, m, n, obstacleGrid, road, visited)
                || backtrack(x, y + 1, m, n, obstacleGrid, road, visited)) {
                return true;
            }

            road.remove(road.size() - 1);

            return false;
        }
    }

}

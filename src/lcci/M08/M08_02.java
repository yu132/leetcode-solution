package lcci.M08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**  
 * @ClassName: M08_02  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月3日  
 *  
 */
public class M08_02 {

    class Solution {
        public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
            if (obstacleGrid.length == 0) {
                return Collections.emptyList();
            }
            List<List<Integer>> ans = new ArrayList<>();
            dfs(0, 0, obstacleGrid, ans);
            return ans;
        }

        public boolean dfs(int x, int y, int[][] obstacleGrid, List<List<Integer>> list) {
            if (x < 0 || x >= obstacleGrid.length || y < 0 || y >= obstacleGrid[0].length) {
                return false;
            }
            if (obstacleGrid[x][y] != 0) {
                return false;
            }
            obstacleGrid[x][y] = 2;
            List<Integer> temp = new ArrayList<>();
            temp.add(x);
            temp.add(y);
            list.add(temp);
            if (x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1) {
                return true;
            }
            if (dfs(x + 1, y, obstacleGrid, list) || dfs(x, y + 1, obstacleGrid, list)) {
                return true;
            }
            list.remove(list.size() - 1);
            return false;
        }
    }


    public static void main(String[] args) {
        new M08_02().new Solution().pathWithObstacles(new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
    }
}

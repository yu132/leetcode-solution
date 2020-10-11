package _1200_1299;

/**  
 * @ClassName: _1267  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月10日  
 *  
 */
public class _1267 {

    class Solution {
        public int countServers(int[][] grid) {
            for (int i = 0; i < grid.length; ++i) {
                int count = 0;
                for (int j = 0; j < grid[0].length; ++j) {
                    if (grid[i][j] > 0) {
                        ++count;
                    }
                }
                if (count > 1) {
                    for (int j = 0; j < grid[0].length; ++j) {
                        if (grid[i][j] == 1) {
                            grid[i][j] = 2;
                        }
                    }
                }
            }

            for (int i = 0; i < grid[0].length; ++i) {
                int count = 0;
                for (int j = 0; j < grid.length; ++j) {
                    if (grid[j][i] > 0) {
                        ++count;
                    }
                }
                if (count > 1) {
                    for (int j = 0; j < grid[0].length; ++j) {
                        if (grid[j][i] == 1) {
                            grid[j][i] = 2;
                        }
                    }
                }
            }

            int count = 0;
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[0].length; ++j) {
                    if (grid[i][j] == 2) {
                        ++count;
                    }
                }
            }

            return count;
        }
    }

}

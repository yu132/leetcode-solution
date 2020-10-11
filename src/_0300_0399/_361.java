package _0300_0399;

/**  
 * @ClassName: _361  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月12日  
 *  
 */
public class _361 {

    class Solution {
        public int maxKilledEnemies(char[][] grid) {
            if (grid.length == 0) {
                return 0;
            }
            int[]   rowl = new int[grid[0].length], rowr = new int[grid[0].length], colu = new int[grid.length],
                cold = new int[grid.length];
            int[][] ans  = new int[grid.length][grid[0].length];

            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[i].length; ++j) {
                    if (grid[i][j] == 'E') {
                        rowl[j] = j == 0 ? 1 : rowl[j - 1] + 1;
                    } else if (grid[i][j] == 'W') {
                        rowl[j] = 0;
                    } else {
                        rowl[j] = j == 0 ? 0 : rowl[j - 1];
                    }
                }

                for (int j = grid[i].length - 1; j >= 0; --j) {
                    if (grid[i][j] == 'E') {
                        rowr[j] = j == grid[i].length - 1 ? 1 : rowr[j + 1] + 1;
                    } else if (grid[i][j] == 'W') {
                        rowr[j] = 0;
                    } else {
                        rowr[j] = j == grid[i].length - 1 ? 0 : rowr[j + 1];
                    }
                }

                for (int j = 0; j < grid[i].length; ++j) {
                    ans[i][j] += rowl[j] + rowr[j] - (grid[i][j] == 'E' ? 1 : 0);
                }
            }

            for (int j = 0; j < grid[0].length; ++j) {
                for (int i = 0; i < grid.length; ++i) {
                    if (grid[i][j] == 'E') {
                        cold[i] = i == 0 ? 1 : cold[i - 1] + 1;
                    } else if (grid[i][j] == 'W') {
                        cold[i] = 0;
                    } else {
                        cold[i] = i == 0 ? 0 : cold[i - 1];
                    }
                }

                for (int i = grid.length - 1; i >= 0; --i) {
                    if (grid[i][j] == 'E') {
                        colu[i] = i == grid.length - 1 ? 1 : colu[i + 1] + 1;
                    } else if (grid[i][j] == 'W') {
                        colu[i] = 0;
                    } else {
                        colu[i] = i == grid.length - 1 ? 0 : colu[i + 1];
                    }
                }

                for (int i = 0; i < grid.length; ++i) {
                    ans[i][j] += cold[i] + colu[i] - (grid[i][j] == 'E' ? 1 : 0);
                }
            }

            int max = 0;
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[i].length; ++j) {
                    if (grid[i][j] == '0') {
                        max = Math.max(max, ans[i][j]);
                    }
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        new _361().new Solution()
            .maxKilledEnemies(new char[][] {{'0', 'E', '0', '0'}, {'E', '0', 'W', 'E'}, {'0', 'E', '0', '0'}});
    }
}

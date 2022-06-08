package redo.contest.lccup;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.Arrs;

/**  
 * @ClassName: P04  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年4月5日  
 *  
 */
public class P04 {

    class Solution {

        boolean[][][][] visited;

        public boolean escapeMaze(List<List<String>> maze) {
            int m = maze.get(0).size(), n = maze.get(0).get(0).length();
            visited = new boolean[m][n][maze.size()][4];
            return dfs(0, 0, m, n, false, -1, -1, 0, maze);
        }

        boolean dfs(int x, int y, int m, int n, boolean useTemp, int ax, int ay,
            int time, List<List<String>> maze) {
            if (x < 0 || x >= m || y < 0 || y >= n) {
                return false;
            }
            if (x == m - 1 && y == n - 1) {
                return true;
            }
            if (m - 1 - x + n - 1 - y >= maze.size() - time) {
                return false;
            }

            boolean flag1 = !useTemp, flag2 = ax == -1 && ay == -1;

            if (flag1 && flag2) {
                if (visited[x][y][time][0]) {
                    return false;
                }
                visited[x][y][time][0] = true;
            } else if (flag1 && !flag2) {
                if (visited[x][y][time][1]) {
                    return false;
                }
                visited[x][y][time][1] = true;
            } else if (!flag1 && flag2) {
                if (visited[x][y][time][2]) {
                    return false;
                }
                visited[x][y][time][2] = true;
            } else {
                if (visited[x][y][time][3]) {
                    return false;
                }
                visited[x][y][time][3] = true;
            }

            List<String> mazeNow = maze.get(time);
            if (mazeNow.get(x).charAt(y) == '#') {
                if (ax != x || ay != y) {
                    if (!useTemp) {
                        return dfs(x + 1, y, m, n, true, ax, ay, time + 1, maze)
                            || dfs(x - 1, y, m, n, true, ax, ay, time + 1, maze)
                            || dfs(x, y + 1, m, n, true, ax, ay, time + 1, maze)
                            || dfs(x, y - 1, m, n, true, ax, ay, time + 1,
                                maze);
                    }
                    if (ax == -1 && ay == -1) {
                        return dfs(x + 1, y, m, n, useTemp, x, y, time + 1,
                            maze)
                            || dfs(x - 1, y, m, n, useTemp, x, y, time + 1,
                                maze)
                            || dfs(x, y + 1, m, n, useTemp, x, y, time + 1,
                                maze)
                            || dfs(x, y - 1, m, n, useTemp, x, y, time + 1,
                                maze);
                    }
                    return false;
                }
            }

            return dfs(x + 1, y, m, n, useTemp, ax, ay, time + 1, maze)
                || dfs(x - 1, y, m, n, useTemp, ax, ay, time + 1, maze)
                || dfs(x, y + 1, m, n, useTemp, ax, ay, time + 1, maze)
                || dfs(x, y - 1, m, n, useTemp, ax, ay, time + 1, maze);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.escapeMaze(Arrs.build2DsL(
            "[[\".#.\",\"#..\"],[\"...\",\".#.\"],[\".##\",\".#.\"],[\"..#\",\".#.\"]]")));
        Assert.assertEquals(false, s.escapeMaze(
            Arrs.build2DsL("[[\".#.\",\"...\"],[\"...\",\"...\"]]")));
        Assert.assertEquals(false, s.escapeMaze(Arrs.build2DsL(
            "[[\"...\",\"...\",\"...\"],[\".##\",\"###\",\"##.\"],[\".##\",\"###\",\"##.\"],[\".##\",\"###\",\"##.\"],[\".##\",\"###\",\"##.\"],[\".##\",\"###\",\"##.\"],[\".##\",\"###\",\"##.\"]]")));

    }

}

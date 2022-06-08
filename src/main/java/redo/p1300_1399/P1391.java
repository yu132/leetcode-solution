package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1391  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月9日  
 *  
 */
public class P1391 {

    static//

    class Solution {
        enum Dir {
            LEFT(0, 1), RIGHT(0, -1), UP(1, 0), DOWN(-1, 0);

            int xBias, yBias;

            private Dir(int xBias, int yBias) {
                this.xBias = xBias;
                this.yBias = yBias;
            }
        }

        enum Street {
            LEFT_1(Dir.LEFT), RIGHT_1(Dir.RIGHT), //
            UP_2(Dir.UP), DOWN_2(Dir.DOWN), //
            LEFT_3(Dir.UP), DOWN_3(Dir.RIGHT), //
            RIGHT_4(Dir.UP), DOWN_4(Dir.LEFT), //
            LEFT_5(Dir.DOWN), UP_5(Dir.RIGHT), //
            RIGHT_6(Dir.DOWN), UP_6(Dir.LEFT), //
            NO_WAY(null);

            Dir out;

            private Street(Dir out) {
                this.out = out;
            }
        }

        private Street[][] streets =
            {{Street.LEFT_1, Street.NO_WAY, Street.LEFT_3, Street.NO_WAY, Street.LEFT_5, Street.NO_WAY},
                {Street.RIGHT_1, Street.NO_WAY, Street.NO_WAY, Street.RIGHT_4, Street.NO_WAY, Street.RIGHT_6},
                {Street.NO_WAY, Street.UP_2, Street.NO_WAY, Street.NO_WAY, Street.UP_5, Street.UP_6},
                {Street.NO_WAY, Street.DOWN_2, Street.DOWN_3, Street.DOWN_4, Street.NO_WAY, Street.NO_WAY}};

        private Dir[][] start = {{Dir.RIGHT}, {Dir.DOWN}, {Dir.DOWN}, {Dir.DOWN, Dir.RIGHT}, {}, {Dir.RIGHT}};

        public boolean hasValidPath(int[][] grid) {
            if (grid.length == 1 && grid[0].length == 1) {
                return true;
            }
            for (Dir dir : start[grid[0][0] - 1]) {
                switch (dir) {
                    case DOWN:
                        if (dfs(Dir.UP, 1, 0, grid, new boolean[grid.length][grid[0].length])) {
                            return true;
                        }
                        break;
                    case RIGHT:
                        if (dfs(Dir.LEFT, 0, 1, grid, new boolean[grid.length][grid[0].length])) {
                            return true;
                        }
                        break;
                    default:
                        break;
                }
            }
            return false;
        }

        public boolean dfs(Dir dir, int x, int y, int[][] grid, boolean[][] visited) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
                return false;
            }
            if (visited[x][y]) {
                return false;
            }
            visited[x][y] = true;
            Street street = null;
            switch (dir) {
                case LEFT:
                    street = streets[0][grid[x][y] - 1];
                    break;
                case RIGHT:
                    street = streets[1][grid[x][y] - 1];
                    break;
                case UP:
                    street = streets[2][grid[x][y] - 1];
                    break;
                case DOWN:
                    street = streets[3][grid[x][y] - 1];
                    break;
                default:
                    throw new RuntimeException("unreachable");
            }
            if (street == Street.NO_WAY) {
                return false;
            }
            if (x == grid.length - 1 && y == grid[0].length - 1) {
                return true;
            }
            return dfs(street.out, x + street.out.xBias, y + street.out.yBias, grid, visited);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.hasValidPath(Arrs.build2D("[[2,4,3],[6,5,2]]")));
        Assert.assertEquals(false, s.hasValidPath(Arrs.build2D("[[1,2,1],[1,2,1]]")));
        Assert.assertEquals(false, s.hasValidPath(Arrs.build2D("[[1,1,2]]")));
        Assert.assertEquals(true, s.hasValidPath(Arrs.build2D("[[1,1,1,1,1,1,3]]")));
        Assert.assertEquals(true, s.hasValidPath(Arrs.build2D("[[2],[2],[2],[2],[2],[2],[6]]")));
        Assert.assertEquals(true, s.hasValidPath(Arrs.build2D("[[1]]")));
        Assert.assertEquals(false, s.hasValidPath(Arrs.build2D("[[4,3,3],[6,5,2]]")));
    }

}

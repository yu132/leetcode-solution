package redo.p0800_0899;

import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.Arrs;

/**  
 * @ClassName: P840  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月29日  
 *  
 */
public class P840 {

    class Solution {
        public int numMagicSquaresInside(int[][] grid) {
            int m = grid.length, n = grid[0].length, count = 0;
            for (int i = 0; i < m - 2; ++i) {

                outer:
                for (int j = 0; j < n - 2; ++j) {

                    boolean[] used = new boolean[10];

                    int[] row = new int[3], col = new int[3];
                    for (int x = i; x < i + 3; ++x) {
                        for (int y = j; y < j + 3; ++y) {

                            if (grid[x][y] == 0 || grid[x][y] >= 10) {
                                continue outer;
                            }

                            if (used[grid[x][y]]) {
                                continue outer;
                            }
                            used[grid[x][y]] = true;

                            row[x - i] += grid[x][y];
                            col[y - j] += grid[x][y];
                        }
                    }
                    for (int x = 0; x < 3; ++x) {
                        if (row[x] != 15 || col[x] != 15) {
                            continue outer;
                        }
                    }
                    if (grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] != 15
                        || grid[i + 2][j] + grid[i + 1][j + 1] + grid[i][j + 2] != 15) {
                        continue outer;
                    }

                    ++count;
                }
            }

            return count;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.numMagicSquaresInside(Arrs.build2D("[[4,3,8,4],[9,5,1,9],[2,7,6,2]]")));
        Assert.assertEquals(0, s.numMagicSquaresInside(Arrs.build2D("[[5,5,5],[5,5,5],[5,5,5]]")));
    }
}

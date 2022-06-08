package redo.p1100_1199;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1139  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月14日  
 *  
 */
public class P1139 {

    static//

    class Solution {
        public int largest1BorderedSquare(int[][] grid) {
            int[][] prefix = prefix2D(grid);
            int m = grid.length, n = grid[0].length;
            for (int k = Math.max(m, n); k >= 1; --k) {
                for (int i = 0; i <= m - k; ++i) {
                    for (int j = 0; j <= n - k; ++j) {
                        if (k != 1) {
                            int sumAll = sum2DRange(i, j, i + k - 1, j + k - 1, prefix);
                            int sumInner = sum2DRange(i + 1, j + 1, i + k - 2, j + k - 2, prefix);
                            if (sumAll - sumInner == 4 * k - 4) {
                                return k * k;
                            }
                        } else {
                            if (grid[i][j] == 1) {
                                return 1;
                            }
                        }
                    }
                }
            }
            return 0;
        }

        public static int[][] prefix2D(int[][] nums) {
            int[][] prefix = new int[nums.length + 1][nums[0].length + 1];
            for (int i = 0; i < nums.length; ++i) {
                for (int j = 0; j < nums[0].length; ++j) {
                    prefix[i + 1][j + 1] = nums[i][j] + prefix[i][j + 1] + prefix[i + 1][j] - prefix[i][j];
                }
            }
            return prefix;
        }

        // x2和y2是包括的右下角边界
        public static int sum2DRange(int x1, int y1, int x2, int y2, int[][] prefix) {
            if (x2 < x1) {
                return 0;
            }
            return prefix[x2 + 1][y2 + 1] - prefix[x2 + 1][y1] - prefix[x1][y2 + 1] + prefix[x1][y1];
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(9, s.largest1BorderedSquare(Arrs.build2D("[[1,1,1],[1,0,1],[1,1,1]]")));
        Assert.assertEquals(1, s.largest1BorderedSquare(Arrs.build2D("[[1,1,0,0]]")));
        Assert.assertEquals(0, s.largest1BorderedSquare(Arrs.build2D("[[0,0,0,0]]")));
    }

}

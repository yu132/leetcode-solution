package redo.p1800_1899;

public class P1895 {

    class Solution {
        public int largestMagicSquare(int[][] grid) {

            int m = grid.length, n = grid[0].length;

            int[][] prefix2D = prefix2D(grid);

            int max = 1;

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    for (int k = Math.min(n - j, m - i); k >= 1; --k) {
                        if (isMagic(grid, i, j, k, prefix2D)) {
                            max = Math.max(max, k);
                        }
                    }
                }
            }

            return max;
        }

        boolean isMagic(int[][] grid, int x, int y, int k, int[][] prefix2D) {
            int a = 0, b = 0;
            for (int i = 0; i < k; ++i) {
                a += grid[x + i][y + i];
                b += grid[x + i][y + k - 1 - i];
            }
            if (a != b) {
                return false;
            }
            for (int i = 0; i < k; ++i) {
                if (sum2DRange(x, y + i, x + k - 1, y + i, prefix2D) != a) {
                    return false;
                }
                if (sum2DRange(x + i, y, x + i, y + k - 1, prefix2D) != a) {
                    return false;
                }
            }

            return true;
        }

        int[][] prefix2D(int[][] nums) {
            int[][] prefix = new int[nums.length + 1][nums[0].length + 1];
            for (int i = 0; i < nums.length; ++i) {
                for (int j = 0; j < nums[0].length; ++j) {
                    prefix[i + 1][j + 1] = nums[i][j] + prefix[i][j + 1]
                            + prefix[i + 1][j] - prefix[i][j];
                }
            }
            return prefix;
        }

        // x2和y2是包括的右下角边界
        int sum2DRange(int x1, int y1, int x2, int y2, int[][] prefix) {
            return prefix[x2 + 1][y2 + 1] - prefix[x2 + 1][y1] - prefix[x1][y2 + 1]
                    + prefix[x1][y1];
        }
    }

}

package redo.p1900_1999;

public class P1901 {

    /*
     * [[1,2,3,4,5,6,7,8],
     * [2,3,4,5,6,7,8,9],
     * [3,4,5,6,7,8,9,10],
     * [4,5,6,7,8,9,10,11]]
     */

    class Solution {

        int[] ans;

        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int[] findPeakGrid(int[][] mat) {
            helper(0, 0, mat.length, mat[0].length, mat);
            return ans;
        }

        void helper(int x, int y, int m, int n, int[][] mat) {
            int maxDir = 0, maxVal = -1;
            for (int i = 0; i < 4; ++i) {
                int val = get(x + dir[i][0], y + dir[i][1], m, n, mat);
                if (val > maxVal) {
                    maxVal = val;
                    maxDir = i;
                }
            }
            if (maxVal < mat[x][y]) {
                ans = new int[]{x, y};
                return;
            }
            helper(x + dir[maxDir][0], y + dir[maxDir][1], m, n, mat);
        }

        int get(int x, int y, int m, int n, int[][] mat) {
            if (x < 0 || x >= m || y < 0 || y >= n) {
                return -1;
            }
            return mat[x][y];
        }
    }

}

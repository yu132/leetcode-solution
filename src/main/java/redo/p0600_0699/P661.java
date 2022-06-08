package redo.p0600_0699;

/**  
 * @ClassName: P661  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P661 {

    class Solution {
        public int[][] imageSmoother(int[][] M) {

            if (M.length == 1 && M[0].length == 1) {
                return M;
            }

            int[][] after = new int[M.length][M[0].length];
            int m = M.length - 1, n = M[0].length - 1;

            if (M[0].length == 1) {
                int sum = M[0][0] + M[1][0];
                after[0][0] = sum / 2;

                sum = M[m][0] + M[m - 1][0];
                after[m][0] = sum / 2;

                for (int i = 1; i < M.length - 1; ++i) {
                    sum = M[i - 1][0] + M[i][0] + M[i + 1][0];
                    after[i][0] = sum / 3;
                }

                return after;
            } else if (M.length == 1) {
                int sum = M[0][0] + M[0][1];
                after[0][0] = sum / 2;

                sum = M[0][n] + M[0][n - 1];
                after[0][n] = sum / 2;

                for (int i = 1; i < M[0].length - 1; ++i) {
                    sum = M[0][i - 1] + M[0][i] + M[0][i + 1];
                    after[0][i] = sum / 3;
                }

                return after;
            }

            {// corner
                int sum = M[0][0] + M[0][1] + M[1][0] + M[1][1];
                after[0][0] = sum / 4;

                sum = M[0][n] + M[0][n - 1] + M[1][n] + M[1][n - 1];
                after[0][n] = sum / 4;

                sum = M[m][0] + M[m][1] + M[m - 1][0] + M[m - 1][1];
                after[m][0] = sum / 4;

                sum = M[m][n] + M[m][n - 1] + M[m - 1][n] + M[m - 1][n - 1];
                after[m][n] = sum / 4;
            }

            for (int i = 1; i < M.length - 1; ++i) {// left & right
                int sum = M[i - 1][0] + M[i - 1][1] + M[i][0] + M[i][1] + M[i + 1][0] + M[i + 1][1];
                after[i][0] = sum / 6;

                sum = M[i - 1][n] + M[i - 1][n - 1] + M[i][n] + M[i][n - 1] + M[i + 1][n] + M[i + 1][n - 1];
                after[i][n] = sum / 6;
            }

            for (int i = 1; i < M[0].length - 1; ++i) {// up & down
                int sum = M[0][i - 1] + M[1][i - 1] + M[0][i] + M[1][i] + M[0][i + 1] + M[1][i + 1];
                after[0][i] = sum / 6;

                sum = M[m][i - 1] + M[m - 1][i - 1] + M[m][i] + M[m - 1][i] + M[m][i + 1] + M[m - 1][i + 1];
                after[m][i] = sum / 6;
            }

            for (int i = 1; i < M.length - 1; ++i) {
                for (int j = 1; j < M[0].length - 1; ++j) {
                    int sum = M[i][j] + M[i - 1][j] + M[i + 1][j] + M[i][j - 1] + M[i][j + 1] + M[i - 1][j - 1]
                        + M[i - 1][j + 1] + M[i + 1][j - 1] + M[i + 1][j + 1];
                    after[i][j] = sum / 9;
                }
            }

            return after;
        }
    }

}

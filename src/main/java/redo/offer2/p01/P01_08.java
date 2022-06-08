package redo.offer2.p01;

/**  
 * @ClassName: P01_08  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P01_08 {

    class Solution {
        public void setZeroes(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            int m = matrix.length, n = matrix[0].length;

            boolean col0 = false, row0 = false;

            if (matrix[0][0] != 0) {
                for (int i = 1; i < m && matrix[0][0] != 0; ++i) {
                    if (matrix[i][0] == 0) {
                        matrix[0][0] = 0;
                        col0 = true;
                    }
                }
                for (int j = 1; j < n; ++j) {
                    if (matrix[0][j] == 0) {
                        matrix[0][0] = 0;
                        row0 = true;
                    }
                }
            } else {
                col0 = true;
                row0 = true;
            }

            for (int i = 1; i < m; ++i) {
                for (int j = 1; j < n && matrix[i][0] != 0; ++j) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }

            for (int j = 1; j < n; ++j) {
                for (int i = 1; i < m && matrix[0][j] != 0; ++i) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }

            for (int i = 1; i < m; ++i) {
                if (matrix[i][0] == 0) {
                    for (int j = 1; j < n; ++j) {
                        matrix[i][j] = 0;
                    }
                }
            }

            for (int j = 1; j < n; ++j) {
                if (matrix[0][j] == 0) {
                    for (int i = 1; i < m; ++i) {
                        matrix[i][j] = 0;
                    }
                }
            }

            if (matrix[0][0] == 0) {
                if (col0) {
                    for (int i = 1; i < m; ++i) {
                        matrix[i][0] = 0;
                    }
                }
                if (row0) {
                    for (int j = 1; j < n; ++j) {
                        matrix[0][j] = 0;
                    }
                }
            }

        }
    }

}

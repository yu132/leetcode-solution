package redo.p0000_0099;

/**  
 * @ClassName: P73  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月11日  
 *  
 */
public class P73 {

    class Solution {
        public void setZeroes(int[][] matrix) {

            if (matrix.length == 0 || matrix[0].length == 0) {
                return;
            }

            int m = matrix.length, n = matrix[0].length;

            boolean c0 = false, r0 = false;

            for (int i = 0; i < m; ++i) {
                if (matrix[i][0] == 0) {
                    c0 = true;
                }
            }

            for (int j = 0; j < n; ++j) {
                if (matrix[0][j] == 0) {
                    r0 = true;
                }
            }

            for (int i = 1; i < m; ++i) {
                for (int j = 1; j < n; ++j) {
                    if (matrix[i][j] == 0) {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }

            for (int i = 1; i < m; ++i) {
                if (matrix[i][0] == 0) {
                    for (int j = 0; j < n; ++j) {
                        matrix[i][j] = 0;
                    }
                }
            }

            for (int j = 0; j < n; ++j) {
                if (matrix[0][j] == 0) {
                    for (int i = 0; i < m; ++i) {
                        matrix[i][j] = 0;
                    }
                }
            }

            if (r0) {
                for (int j = 0; j < n; ++j) {
                    matrix[0][j] = 0;
                }
            }

            if (c0) {
                for (int i = 0; i < m; ++i) {
                    matrix[i][0] = 0;
                }
            }
        }
    }

}

package redo.offer2.p01;

/**  
 * @ClassName: P01_07  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P01_07 {

    class Solution {
        public void rotate(int[][] matrix) {
            transposition(matrix);
            reversse(matrix);
        }

        public void transposition(int[][] matrix) {
            int n = matrix.length;
            for (int i = 1; i < n; ++i) {
                for (int j = 0; j < i; ++j) {
                    int temp = matrix[j][i];
                    matrix[j][i] = matrix[i][j];
                    matrix[i][j] = temp;
                }
            }
        }

        public void reversse(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n / 2; ++j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][n - j - 1];
                    matrix[i][n - j - 1] = temp;
                }
            }
        }
    }

}

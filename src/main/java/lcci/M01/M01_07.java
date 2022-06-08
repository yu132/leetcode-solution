package lcci.M01;

/**  
 * @ClassName: M01_07  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月26日  
 *  
 */
public class M01_07 {

    class Solution {
        public void rotate(int[][] matrix) {
            transposition(matrix);
            leftRightSymmetrically(matrix);
        }

        public void transposition(int[][] matrix) {
            for (int i = 0; i < matrix.length - 1; ++i) {
                for (int j = i + 1; j < matrix.length; ++j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        public void leftRightSymmetrically(int[][] matrix) {
            for (int i = 0; i < matrix.length; ++i) {
                reverse(matrix[i], 0, matrix[i].length - 1);
            }
        }

        public void reverse(int[] array, int from, int to) {
            for (; from < to; ++from, --to) {
                int temp = array[from];
                array[from] = array[to];
                array[to]   = temp;
            }
        }
    }

}

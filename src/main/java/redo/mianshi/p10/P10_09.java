package redo.mianshi.p10;

/**  
 * @ClassName: P10_09  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月11日  
 *  
 */
public class P10_09 {

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }
            int m = matrix.length, n = matrix[0].length;

            int i = m - 1, j = 0;

            while (i >= 0 && j < n) {
                if (matrix[i][j] < target) {
                    ++j;
                } else if (matrix[i][j] > target) {
                    --i;
                } else {
                    return true;
                }
            }

            return false;
        }
    }

}

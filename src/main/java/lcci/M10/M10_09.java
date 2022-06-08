package lcci.M10;

/**  
 * @ClassName: M10_09  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月8日  
 *  
 */
public class M10_09 {

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) {
                return false;
            }
            int width = matrix[0].length, height = matrix.length;
            int i     = 0, j = width - 1;
            while (i < height && j >= 0) {
                if (matrix[i][j] > target) {
                    j -= 1;
                } else if (matrix[i][j] < target) {
                    i += 1;
                } else {
                    return true;
                }
            }
            return false;
        }
    }

}

package redo.p0200_0299;

/**  
 * @ClassName: P240  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P240 {

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {

            if (matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }

            int m = matrix.length, n = matrix[0].length;

            int x = m - 1, y = 0;

            while (x >= 0 && y < n) {
                if (matrix[x][y] < target) {
                    ++y;
                } else if (matrix[x][y] > target) {
                    --x;
                } else {
                    return true;
                }
            }

            return false;
        }
    }

}

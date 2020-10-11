package lcof;

/**  
 * @ClassName: M04  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月12日  
 *  
 */
public class M04 {

    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {

            for (int i = 0; i < matrix.length; ++i) {
                for (int j = 0; j < matrix[i].length; ++j) {
                    if (matrix[i][j] == target) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

}

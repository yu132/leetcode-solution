package redo.p0000_0099;

import java.util.Arrays;

/**  
 * @ClassName: P74  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P74 {

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {

            for (int i = 0; i < matrix.length; ++i) {
                if (target <= matrix[i][matrix[0].length - 1]) {
                    return Arrays.binarySearch(matrix[i], target) >= 0;
                }
            }

            return false;
        }
    }

}

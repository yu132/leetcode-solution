package old._1300_1399;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: _1380  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月5日  
 *  
 */
public class _1380 {

    class Solution {
        public List<Integer> luckyNumbers(int[][] matrix) {
            int[] max = new int[matrix[0].length];
            int[] min = new int[matrix.length];

            for (int i = 0; i < matrix.length; ++i) {
                int m     = matrix[i][0];
                int index = 0;
                for (int j = 1; j < matrix[0].length; ++j) {
                    if (m > matrix[i][j]) {
                        m     = matrix[i][j];
                        index = j;
                    }
                }
                min[i] = index;
            }

            for (int j = 0; j < matrix[0].length; ++j) {
                int m     = matrix[0][j];
                int index = 0;
                for (int i = 1; i < matrix.length; ++i) {
                    if (m < matrix[i][j]) {
                        m     = matrix[i][j];
                        index = i;
                    }
                }
                max[j] = index;
            }

            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < min.length; ++i) {
                int col = min[i];
                if (max[col] == i) {
                    ans.add(matrix[i][col]);
                }
            }

            return ans;
        }
    }

}

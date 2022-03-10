package redo2012_05_29start;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: P0054  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年6月5日  
 *  
 */
public class P0054 {

    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {

            int m = matrix.length, n = matrix[0].length;
            int up = 0, down = m - 1, left = 0, right = n - 1;

            List<Integer> ans = new ArrayList<>(m * n);

            while (ans.size() < m * n) {
                for (int i = left; i <= right && ans.size() < m * n; ++i) {
                    ans.add(matrix[up][i]);
                }
                ++up;
                for (int i = up; i <= down && ans.size() < m * n; ++i) {
                    ans.add(matrix[i][right]);
                }
                --right;
                for (int i = right; i >= left && ans.size() < m * n; --i) {
                    ans.add(matrix[down][i]);
                }
                --down;
                for (int i = down; i >= up && ans.size() < m * n; --i) {
                    ans.add(matrix[i][left]);
                }
                ++left;
            }

            return ans;

        }
    }

}

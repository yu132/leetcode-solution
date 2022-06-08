package reredo;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: P0054  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月3日  
 *  
 */
public class P0054 {

    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {

            List<Integer> ans = new ArrayList<>();

            int m = matrix.length, n = matrix[0].length;

            int total = m * n;

            int top = 0, bottom = m - 1, left = 0, right = n - 1;

            while (ans.size() < total) {
                for (int i = left; i <= right && ans.size() < total; ++i) {
                    ans.add(matrix[top][i]);
                }
                ++top;
                for (int i = top; i <= bottom && ans.size() < total; ++i) {
                    ans.add(matrix[i][right]);
                }
                --right;
                for (int i = right; i >= left && ans.size() < total; --i) {
                    ans.add(matrix[bottom][i]);
                }
                --bottom;
                for (int i = bottom; i >= top && ans.size() < total; --i) {
                    ans.add(matrix[i][left]);
                }
                ++left;
            }

            return ans;
        }
    }

}

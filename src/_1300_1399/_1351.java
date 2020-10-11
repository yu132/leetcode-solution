package _1300_1399;

/**  
 * @ClassName: _1351  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月10日  
 *  
 */
public class _1351 {

    class Solution {
        public int countNegatives(int[][] grid) {

            int count = 0;
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[i].length; ++j) {
                    if (grid[i][j] < 0) {
                        ++count;
                    }
                }
            }

            return count;
        }
    }

}

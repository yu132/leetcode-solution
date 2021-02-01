package redo.p0800_0899;

import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.Arrs;

/**  
 * @ClassName: P807  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月1日  
 *  
 */
public class P807 {

    class Solution {
        public int maxIncreaseKeepingSkyline(int[][] grid) {
            int n = grid.length;
            int[] rowMax = new int[n], colMax = new int[n];

            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                    colMax[j] = Math.max(colMax[j], grid[i][j]);
                }
            }

            int ans = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    ans += Math.max(Math.min(rowMax[i], colMax[j]) - grid[i][j],
                        0);
                }
            }

            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(35, s.maxIncreaseKeepingSkyline(
            Arrs.build2D("[[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]")));
    }

}

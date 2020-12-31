package redo.p1700_1799;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1706  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月31日  
 *  
 */
public class P1706 {

    class Solution {
        public int[] findBall(int[][] grid) {
            int[] ans = new int[grid[0].length];
            for (int i = 0; i < ans.length; ++i) {
                ans[i] = helper(i, 0, 0, grid);
            }
            return ans;
        }

        /*
         * to dir:0 down, 1 left 2, right
         */
        public int helper(int index, int level, int dir, int[][] grid) {
            if (index < 0 || index >= grid[0].length) {
                return -1;
            }
            if (dir == 1 && grid[level][index] == 1) {
                return -1;
            } else if (dir == 2 && grid[level][index] == -1) {
                return -1;
            }
            if (dir == 0) {
                if (grid[level][index] == 1) {
                    return helper(index + 1, level, 2, grid);
                } else {
                    return helper(index - 1, level, 1, grid);
                }
            }
            if (level == grid.length - 1) {
                return index;
            }
            return helper(index, level + 1, 0, grid);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {1, -1, -1, -1, -1},
            s.findBall(Arrs.build2D("[[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]")));
    }

}

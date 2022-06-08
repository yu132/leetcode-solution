package redo.p0500_0599;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P566  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P566 {

    class Solution {
        public int[][] matrixReshape(int[][] nums, int r, int c) {
            if (nums.length == 0 || nums.length * nums[0].length != r * c
                || (nums.length == r && nums[0].length == c)) {
                return nums;
            }
            int[][] after = new int[r][c];

            int x = 0, y = 0;

            for (int i = 0; i < r; ++i) {
                for (int j = 0; j < c; ++j) {
                    if (y == nums[0].length) {
                        y = 0;
                        ++x;
                    }
                    after[i][j] = nums[x][y];
                    ++y;
                }
            }

            return after;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[[1,2,3,4]]",
            Arrays.deepToString(s.matrixReshape(new int[][] {{1, 2}, {3, 4}}, 1, 4)).replaceAll("\\s", ""));
        Assert.assertEquals("[[1,2],[3,4]]",
            Arrays.deepToString(s.matrixReshape(new int[][] {{1, 2}, {3, 4}}, 2, 4)).replaceAll("\\s", ""));
    }

}

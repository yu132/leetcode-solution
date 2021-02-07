package redo.offer;

import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.Arrs;

/**  
 * @ClassName: P29  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P29 {

    class Solution {
        public int[] spiralOrder(int[][] matrix) {

            if (matrix.length == 0 || matrix[0].length == 0) {
                return new int[0];
            }

            int m = matrix.length, n = matrix[0].length, len = m * n, index = 0,
                up = 0, bottom = m - 1, left = 0, right = n - 1;

            int[] ans = new int[len];

            while (index < len) {
                for (int i = left; i <= right && index < len; ++i) {
                    ans[index++] = matrix[up][i];
                }
                ++up;
                for (int i = up; i <= bottom && index < len; ++i) {
                    ans[index++] = matrix[i][right];
                }
                --right;
                for (int i = right; i >= left && index < len; --i) {
                    ans[index++] = matrix[bottom][i];
                }
                --bottom;
                for (int i = bottom; i >= up && index < len; --i) {
                    ans[index++] = matrix[i][left];
                }
                ++left;
            }
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {1, 2, 3, 6, 9, 8, 7, 4, 5},
            s.spiralOrder(Arrs.build2D("[[1,2,3],[4,5,6],[7,8,9]]")));
        Assert.assertArrayEquals(
            new int[] {1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7},
            s.spiralOrder(Arrs.build2D("[[1,2,3,4],[5,6,7,8],[9,10,11,12]]")));

    }

}

package redo.offer;

import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.Arrs;

/**  
 * @ClassName: P04  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月2日  
 *  
 */
public class P04 {

    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {

            if (matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }

            int m = matrix.length, n = matrix[0].length, x = m - 1, y = 0;

            while (x >= 0 && y < n) {
                if (matrix[x][y] == target) {
                    return true;
                } else if (matrix[x][y] < target) {
                    ++y;
                } else {
                    --x;
                }
            }

            return false;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        int[][] arr = Arrs.build2D(
            "[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]");
        Assert.assertEquals(true, s.findNumberIn2DArray(arr, 5));
        Assert.assertEquals(false, s.findNumberIn2DArray(arr, 20));
    }

}

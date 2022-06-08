package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1314  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月10日  
 *  
 */
public class P1314 {

    static//

    class Solution {
        public int[][] matrixBlockSum(int[][] mat, int K) {
            int[][] prefix = prefix2D(mat);
            for (int i = 0; i < mat.length; ++i) {
                for (int j = 0; j < mat[0].length; ++j) {
                    int x1 = Math.max(0, i - K);
                    int y1 = Math.max(0, j - K);
                    int x2 = Math.min(mat.length - 1, i + K);
                    int y2 = Math.min(mat[0].length - 1, j + K);
                    mat[i][j] = sum2DRange(x1, y1, x2, y2, prefix);
                }
            }
            return mat;
        }

        public static int sum2DRange(int x1, int y1, int x2, int y2, int[][] prefix) {
            return prefix[x2 + 1][y2 + 1] - prefix[x2 + 1][y1] - prefix[x1][y2 + 1] + prefix[x1][y1];
        }

        public static int[][] prefix2D(int[][] nums) {
            int[][] prefix = new int[nums.length + 1][nums[0].length + 1];
            for (int i = 0; i < nums.length; ++i) {
                for (int j = 0; j < nums[0].length; ++j) {
                    prefix[i + 1][j + 1] = nums[i][j] + prefix[i][j + 1] + prefix[i + 1][j] - prefix[i][j];
                }
            }
            return prefix;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[[12,21,16],[27,45,33],[24,39,28]]",
            Arrs.toStr(s.matrixBlockSum(Arrs.build2D("[[1,2,3],[4,5,6],[7,8,9]]"), 1)));
        Assert.assertEquals("[[45,45,45],[45,45,45],[45,45,45]]",
            Arrs.toStr(s.matrixBlockSum(Arrs.build2D("[[1,2,3],[4,5,6],[7,8,9]]"), 2)));
    }

}

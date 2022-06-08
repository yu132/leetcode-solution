package redo.p1200_1299;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1292  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月11日  
 *  
 */
public class P1292 {

    static//

    class Solution {
        public int maxSideLength(int[][] mat, int threshold) {
            int[][] prefix = prefix2D(mat);

            int m = mat.length, n = mat[0].length;

            int low = 0, high = Math.min(m, n) + 1;

            while (low < high) {
                int mid = (low + high) >>> 1;
                if (check(prefix, m, n, mid, threshold)) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low - 1;
        }

        public boolean check(int[][] prefix, int m, int n, int x, int threshold) {
            for (int i = 0; i <= m - x; ++i) {
                for (int j = 0; j <= n - x; ++j) {
                    if (sum2DRange(i, j, i + x - 1, j + x - 1, prefix) <= threshold) {
                        return true;
                    }
                }
            }
            return false;
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

        // x2和y2是包括的右下角边界
        public static int sum2DRange(int x1, int y1, int x2, int y2, int[][] prefix) {
            return prefix[x2 + 1][y2 + 1] - prefix[x2 + 1][y1] - prefix[x1][y2 + 1] + prefix[x1][y1];
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.maxSideLength(Arrs.build2D("[[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]]"), 4));
        Assert.assertEquals(0,
            s.maxSideLength(Arrs.build2D("[[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]]"), 1));
        Assert.assertEquals(3, s.maxSideLength(Arrs.build2D("[[1,1,1,1],[1,0,0,0],[1,0,0,0],[1,0,0,0]]"), 6));
        Assert.assertEquals(2,
            s.maxSideLength(Arrs.build2D("[[18,70],[61,1],[25,85],[14,40],[11,96],[97,96],[63,45]]"), 40184));
    }

}

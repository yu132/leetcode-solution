package redo.p0800_0899;

import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.Arrs;

/**  
 * @ClassName: P835  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月30日  
 *  
 */
public class P835 {

    class Solution {
        public int largestOverlap(int[][] img1, int[][] img2) {
            int n = img1.length;
            int[][] count = new int[2 * n + 1][2 * n + 1];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (img1[i][j] == 1) {
                        for (int x = 0; x < n; ++x) {
                            for (int y = 0; y < n; ++y) {
                                if (img2[x][y] == 1) {
                                    ++count[i - x + n][j - y + n];
                                }
                            }
                        }
                    }
                }
            }

            int ans = 0;
            for (int[] biasRow : count) {
                for (int col : biasRow) {
                    ans = Math.max(col, ans);
                }
            }

            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3,
            s.largestOverlap(Arrs.build2D("[[1,1,0],[0,1,0],[0,1,0]]"),
                Arrs.build2D("[[0,0,0],[0,1,1],[0,0,1]]")));
    }

}

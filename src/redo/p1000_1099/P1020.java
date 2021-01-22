package redo.p1000_1099;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1020  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月19日  
 *  
 */
public class P1020 {

    class Solution {

        int notAns;

        public int numEnclaves(int[][] A) {

            if (A.length == 1 || A[0].length == 1) {
                return 0;
            }

            int m = A.length, n = A[0].length;

            notAns = 0;

            for (int i = 0; i < m; ++i) {
                dfs(i, 0, A);
                dfs(i, n - 1, A);
            }

            for (int i = 0; i < n; ++i) {
                dfs(0, i, A);
                dfs(m - 1, i, A);
            }

            int count = 0;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (A[i][j] == 1 || A[i][j] == 2) {
                        ++count;
                    }
                }
            }

            return count - notAns;
        }

        void dfs(int x, int y, int[][] A) {
            if (x < 0 || x >= A.length || y < 0 || y >= A[0].length) {
                return;
            }
            if (A[x][y] != 1) {
                return;
            }
            ++notAns;
            A[x][y] = 2;
            dfs(x + 1, y, A);
            dfs(x - 1, y, A);
            dfs(x, y + 1, A);
            dfs(x, y - 1, A);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.numEnclaves(Arrs.build2D("[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]")));
        Assert.assertEquals(0, s.numEnclaves(Arrs.build2D("[[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]")));
    }
}

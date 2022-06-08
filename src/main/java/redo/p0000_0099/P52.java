package redo.p0000_0099;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P52  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月13日  
 *  
 */
public class P52 {

    static//

    class Solution {

        int ans;

        public int totalNQueens(int n) {
            ans = 0;
            backtrack(0, n, new Used(n));
            return ans;
        }

        void backtrack(int row, int n, Used used) {
            if (row == n) {
                ++ans;
                return;
            }
            for (int col = 0; col < n; ++col) {
                if (used.tryUse(row, col)) {
                    backtrack(row + 1, n, used);
                    used.resue(row, col);
                }
            }
        }

        static class Used {
            boolean[] row, col, dia, counterDia;
            int n;

            public Used(int n) {
                super();
                row = new boolean[n];
                col = new boolean[n];
                dia = new boolean[2 * n - 1];
                counterDia = new boolean[2 * n - 1];
                this.n = n;
            }

            boolean tryUse(int x, int y) {
                if (row[x] || col[y] || dia[x - y + n - 1] || counterDia[x + y]) {
                    return false;
                }
                row[x] = true;
                col[y] = true;
                dia[x - y + n - 1] = true;
                counterDia[x + y] = true;
                return true;
            }

            void resue(int x, int y) {
                row[x] = false;
                col[y] = false;
                dia[x - y + n - 1] = false;
                counterDia[x + y] = false;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.totalNQueens(1));
        Assert.assertEquals(2, s.totalNQueens(4));
    }
}

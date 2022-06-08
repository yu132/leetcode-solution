package redo.p0000_0099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P51  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月13日  
 *  
 */
public class P51 {

    static//

    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> ans = new ArrayList<>();
            backtrack(0, n, new Used(n), new ArrayList<>(), ans);
            return ans;
        }

        void backtrack(int row, int n, Used used, List<Integer> queens, List<List<String>> ans) {
            if (row == n) {
                addAns(queens, ans, n);
                return;
            }
            for (int col = 0; col < n; ++col) {
                if (used.tryUse(row, col)) {
                    queens.add(row * n + col);
                    backtrack(row + 1, n, used, queens, ans);
                    queens.remove(queens.size() - 1);
                    used.resue(row, col);
                }
            }
        }

        void addAns(List<Integer> queens, List<List<String>> ans, int n) {
            char[][] chs = new char[n][n];
            for (int i = 0; i < n; ++i) {
                Arrays.fill(chs[i], '.');
            }
            for (int index : queens) {
                int x = index / n, y = index % n;
                chs[x][y] = 'Q';
            }
            List<String> list = new ArrayList<>();
            for (char[] c : chs) {
                list.add(String.valueOf(c));
            }
            ans.add(list);
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
        Assert.assertEquals("[[Q]]", Arrs.toLStr(s.solveNQueens(1)));
        Assert.assertEquals("[[.Q..,...Q,Q...,..Q.],[..Q.,Q...,...Q,.Q..]]", Arrs.toLStr(s.solveNQueens(4)));
    }

}

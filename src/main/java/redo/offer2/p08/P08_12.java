package redo.offer2.p08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**  
 * @ClassName: P08_12  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月10日  
 *  
 */
public class P08_12 {

    class Solution {
        public List<List<String>> solveNQueens(int n) {

            boolean[] col = new boolean[n], dia = new boolean[2 * n - 1],
                adia = new boolean[2 * n - 1];

            char[][] board = new char[n][n];

            for (char[] ch : board) {
                Arrays.fill(ch, '.');
            }

            List<List<String>> ans = new ArrayList<>();

            backtrack(0, n, col, dia, adia, board, ans);

            return ans;
        }

        void backtrack(int x, int n, boolean[] col, boolean[] dia,
            boolean[] adia, char[][] board, List<List<String>> ans) {
            if (x == n) {
                ans.add(getAns(board));
                return;
            }
            for (int j = 0; j < n; ++j) {
                if (col[j] || dia[j - x + n - 1] || adia[x + j]) {
                    continue;
                }
                col[j] = dia[j - x + n - 1] = adia[x + j] = true;
                board[x][j] = 'Q';
                backtrack(x + 1, n, col, dia, adia, board, ans);
                board[x][j] = '.';
                col[j] = dia[j - x + n - 1] = adia[x + j] = false;
            }
        }

        List<String> getAns(char[][] board) {
            List<String> ans = new ArrayList<>();
            for (char[] chs : board) {
                ans.add(String.valueOf(chs));
            }
            return ans;
        }
    }

}

package redo.p0100_0199;

/**  
 * @ClassName: P130  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月13日  
 *  
 */
public class P130 {

    class Solution {
        public void solve(char[][] board) {
            if (board.length == 0 || board[0].length == 0) {
                return;
            }

            int m = board.length, n = board[0].length;

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (board[i][j] == 'O') {
                        board[i][j] = '1';
                    }
                }
            }

            for (int i = 0; i < m; ++i) {
                paint(i, 0, m, n, board);
                paint(i, n - 1, m, n, board);
            }

            for (int j = 0; j < n; ++j) {
                paint(0, j, m, n, board);
                paint(m - 1, j, m, n, board);
            }

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (board[i][j] == '1') {
                        board[i][j] = 'X';
                    }
                }
            }
        }

        void paint(int x, int y, int m, int n, char[][] board) {
            if (x < 0 || x >= m || y < 0 || y >= n) {
                return;
            }
            if (board[x][y] != '1') {
                return;
            }
            board[x][y] = 'O';

            paint(x + 1, y, m, n, board);
            paint(x - 1, y, m, n, board);
            paint(x, y + 1, m, n, board);
            paint(x, y - 1, m, n, board);
        }
    }

}

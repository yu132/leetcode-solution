package redo.p0200_0299;

import java.util.Arrays;

/**  
 * @ClassName: P289  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月14日  
 *  
 */
public class P289 {

    class Solution {
        public void gameOfLife(int[][] board) {
            if (board.length == 0 || board[0].length == 0) {
                return;
            }
            int m = board.length, n = board[0].length;

            int[][] copy = new int[m][];

            for (int i = 0; i < m; ++i) {
                copy[i] = Arrays.copyOf(board[i], n);
            }

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    int c = count(i, j, m, n, copy);
                    if (copy[i][j] == 1) {
                        if (c < 2 || c > 3) {
                            board[i][j] = 0;
                        }
                    } else {
                        if (c == 3) {
                            board[i][j] = 1;
                        }
                    }
                }
            }
        }

        int count(int x, int y, int m, int n, int[][] board) {
            int count = 0;
            count += get(x + 1, y + 1, m, n, board);
            count += get(x + 1, y, m, n, board);
            count += get(x + 1, y - 1, m, n, board);
            count += get(x, y + 1, m, n, board);
            count += get(x, y - 1, m, n, board);
            count += get(x - 1, y + 1, m, n, board);
            count += get(x - 1, y, m, n, board);
            count += get(x - 1, y - 1, m, n, board);
            return count;
        }

        int get(int x, int y, int m, int n, int[][] board) {
            if (x < 0 || x >= m || y < 0 || y >= n) {
                return 0;
            }
            return board[x][y];
        }
    }

}

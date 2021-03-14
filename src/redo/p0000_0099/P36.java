package redo.p0000_0099;

/**  
 * @ClassName: P36  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月11日  
 *  
 */
public class P36 {

    class Solution {
        public boolean isValidSudoku(char[][] board) {
            boolean[][] row = new boolean[9][10], col = new boolean[9][10],
                p3x3 = new boolean[9][10];

            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    if (board[i][j] == '.') {
                        continue;
                    }
                    if (!use(i, j, board[i][j] - '0', row, col, p3x3)) {
                        return false;
                    }
                }
            }

            return true;
        }

        boolean use(int x, int y, int val, boolean[][] row, boolean[][] col,
            boolean[][] p3x3) {
            if (row[x][val] || col[y][val] || p3x3[x / 3 + (y / 3 * 3)][val]) {
                return false;
            }
            return row[x][val] =
                col[y][val] = p3x3[x / 3 + (y / 3 * 3)][val] = true;
        }
    }

}

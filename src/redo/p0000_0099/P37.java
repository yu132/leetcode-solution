package redo.p0000_0099;

import java.util.Base64;

import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.Arrs;

/**  
 * @ClassName: P37  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月1日  
 *  
 */
public class P37 {

    class Solution {
        public void solveSudoku(char[][] board) {
            Used used = new Used(board);
            backtrack(0, 0, board, used);
        }

        boolean backtrack(int x, int y, char[][] board, Used used) {
            if (y == 9) {
                ++x;
                y = 0;
            }
            if (x == 9) {
                return true;
            }
            if (board[x][y] != '.') {
                return backtrack(x, y + 1, board, used);
            }
            for (int i = 1; i <= 9; ++i) {
                if (used.use(x, y, i)) {
                    if (backtrack(x, y + 1, board, used)) {
                        board[x][y] = (char)('0' + i);
                        return true;
                    }
                    used.reuse(x, y, i);
                }
            }
            return false;
        }

        class Used {

            boolean[][] col = new boolean[9][10], row = new boolean[9][10],
                p3x3 = new boolean[9][10];

            Used(char[][] board) {
                for (int i = 0; i < 9; ++i) {
                    for (int j = 0; j < 9; ++j) {
                        if (board[i][j] != '.') {
                            use(i, j, board[i][j] - '0');
                        }
                    }
                }
            }

            boolean use(int x, int y, int val) {
                if (col[y][val] || row[x][val]
                    || p3x3[x / 3 + y / 3 * 3][val]) {
                    return false;
                }
                col[y][val] = row[x][val] = p3x3[x / 3 + y / 3 * 3][val] = true;
                return true;
            }

            void reuse(int x, int y, int val) {
                col[y][val] =
                    row[x][val] = p3x3[x / 3 + y / 3 * 3][val] = false;
            }

        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        s.solveSudoku(Arrs.build2Dc(
            "[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]"));
    }

}

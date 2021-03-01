package redo.p0000_0099;

/**  
 * @ClassName: P79  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P79 {

    class Solution {
        public boolean exist(char[][] board, String word) {
            if (board.length == 0 || board[0].length == 0) {
                return false;
            }
            int m = board.length, n = board[0].length;

            boolean[][] visited = new boolean[m][n];

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (backtrack(i, j, m, n, 0, board, word, visited)) {
                        return true;
                    }
                }
            }

            return false;
        }

        boolean backtrack(int x, int y, int m, int n, int index, char[][] board,
            String word, boolean[][] visited) {
            if (index == word.length()) {
                return true;
            }
            if (x < 0 || x >= m || y < 0 || y >= n) {
                return false;
            }
            if (board[x][y] != word.charAt(index)) {
                return false;
            }
            if (visited[x][y]) {
                return false;
            }
            visited[x][y] = true;
            boolean flag = backtrack(x + 1, y, m, n, index + 1, board, word,
                visited)
                || backtrack(x - 1, y, m, n, index + 1, board, word, visited)
                || backtrack(x, y + 1, m, n, index + 1, board, word, visited)
                || backtrack(x, y - 1, m, n, index + 1, board, word, visited);
            visited[x][y] = false;
            return flag;
        }
    }

}

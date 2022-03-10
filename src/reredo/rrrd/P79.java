package reredo.rrrd;

/**  
 * @ClassName: P79  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月24日  
 *  
 */
public class P79 {

    class Solution {
        public boolean exist(char[][] board, String word) {

            if (board.length == 0 || board[0].length == 0) {
                return false;
            }

            int m = board.length, n = board[0].length;

            boolean[][] used = new boolean[m][n];

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (dfs(i, j, m, n, 0, board, word, used)) {
                        return true;
                    }
                }
            }

            return false;
        }

        boolean dfs(int x, int y, int m, int n, int index, char[][] board,
            String word, boolean[][] used) {
            if (index == word.length()) {
                return true;
            }
            if (x < 0 || x >= m || y < 0 || y >= n) {
                return false;
            }
            if (board[x][y] != word.charAt(index)) {
                return false;
            }
            if (used[x][y]) {
                return false;
            }
            used[x][y] = true;
            boolean flag = dfs(x + 1, y, m, n, index + 1, board, word, used)
                || dfs(x - 1, y, m, n, index + 1, board, word, used)
                || dfs(x, y + 1, m, n, index + 1, board, word, used)
                || dfs(x, y - 1, m, n, index + 1, board, word, used);
            used[x][y] = false;
            return flag;
        }
    }

}

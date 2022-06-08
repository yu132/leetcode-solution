package lcof;

/**  
 * @ClassName: M12  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月14日  
 *  
 */
public class M12 {

    class Solution {
        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board[0].length; ++j) {
                    if (dfs(board, word, 0, i, j, new boolean[board.length][board[0].length])) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean dfs(char[][] board, String word, int indexOfStr, int x, int y, boolean[][] visited) {
            if (x >= board.length || x < 0) {
                return false;
            } else if (y >= board[0].length || y < 0) {
                return false;
            } else if (visited[x][y]) {
                return false;
            } else if (board[x][y] != word.charAt(indexOfStr)) {
                return false;
            }

            visited[x][y] = true;

            if (indexOfStr == word.length() - 1) {
                return true;
            }

            if (dfs(board, word, indexOfStr + 1, x + 1, y, visited)
                || dfs(board, word, indexOfStr + 1, x - 1, y, visited)
                || dfs(board, word, indexOfStr + 1, x, y + 1, visited)
                || dfs(board, word, indexOfStr + 1, x, y - 1, visited)) {
                return true;
            }

            visited[x][y] = false;// 回溯

            return false;
        }
    }

}

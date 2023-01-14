package old._0500_0599;

/**  
 * @ClassName: _529  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月30日  
 *  
 */
public class _529 {

    class Solution {
        public char[][] updateBoard(char[][] board, int[] click) {

            int x = click[0];
            int y = click[1];

            if (board[x][y] == 'M') {
                board[x][y] = 'X';
                return board;
            }

            tryOpen(board, x, y);
            return board;
        }

        private int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};

        public void tryOpen(char[][] board, int x, int y) {
            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
                return;
            }
            if (board[x][y] != 'E') {
                return;
            }
            int count = 0;
            for (int i = 0; i < dir.length; ++i) {
                if (isMine(board, x + dir[i][0], y + dir[i][1])) {
                    ++count;
                }
            }
            if (count > 0) {
                board[x][y] = (char)(count + '0');
            } else {
                board[x][y] = 'B';
                for (int i = 0; i < dir.length; ++i) {
                    tryOpen(board, x + dir[i][0], y + dir[i][1]);
                }
            }
        }

        public boolean isMine(char[][] board, int x, int y) {
            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
                return false;
            }
            return board[x][y] == 'M';
        }
    }

    public static void main(String[] args) {
        char[][] ans = new _529().new Solution().updateBoard(new char[][] {{'E', 'E', 'E', 'E', 'E'},
            {'E', 'E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}}, new int[] {0, 0});
        for (int i = 0; i < ans.length; ++i) {
            for (int j = 0; j < ans[0].length; ++j) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

}

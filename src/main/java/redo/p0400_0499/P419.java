package redo.p0400_0499;

/**  
 * @ClassName: P419  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月16日  
 *  
 */
public class P419 {

    class Solution {
        public int countBattleships(char[][] board) {

            if (board.length == 0 || board[0].length == 0) {
                return 0;
            }

            int m = board.length, n = board[0].length;

            int count = 0;

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (board[i][j] == 'X'
                        && ((i == 0 || board[i - 1][j] != 'X')
                            && (j == 0 || board[i][j - 1] != 'X'))) {
                        ++count;
                    }
                }
            }

            return count;
        }
    }

}

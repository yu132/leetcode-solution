package _0200_0299;

/**  
 * @ClassName: _294  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月10日  
 *  
 */
public class _294 {

    class Solution {
        public boolean canWin(String s) {
            boolean[] board = new boolean[s.length()];
            for (int i = 0; i < s.length(); ++i) {
                board[i] = s.charAt(i) == '+';
            }
            return canWin(board);
        }

        public boolean canWin(boolean[] board) {
            for (int i = 1; i < board.length; ++i) {
                if (board[i] && board[i - 1]) {
                    board[i]     = false;
                    board[i - 1] = false;
                    if (!canWin(board)) {
                        board[i]     = true;
                        board[i - 1] = true;
                        return true;
                    }
                    board[i]     = true;
                    board[i - 1] = true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new _294().new Solution().canWin("++++"));
    }
}

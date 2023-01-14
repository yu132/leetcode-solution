package old._0300_0399;

/**  
 * @ClassName: _348  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月11日  
 *  
 */
public class _348 {

    class TicTacToe {

        private int size;
        private int[] row, col;
        private int diagonal, anti_diagonal;

        /** Initialize your data structure here. */
        public TicTacToe(int n) {
            size = n;

            row  = new int[size];
            col  = new int[size];
        }

        /** Player {player} makes a move at ({row}, {col}).
            @param row The row of the board.
            @param col The column of the board.
            @param player The player, can be either 1 or 2.
            @return The current winning condition, can be either:
                    0: No one wins.
                    1: Player 1 wins.
                    2: Player 2 wins. */
        public int move(int row, int col, int player) {
            int nowTurn = player == 1 ? 1 : -1;

            this.row[row] += nowTurn;
            this.col[col] += nowTurn;
            if (row == col) {
                diagonal += nowTurn;
            }
            if (row == size - 1 - col) {
                anti_diagonal += nowTurn;
            }

            return checkSuccess(row, col, nowTurn) ? player : 0;
        }

        private boolean checkSuccess(int x, int y, int nowTurn) {
            int target = nowTurn * size;
            return col[y] == target || row[x] == target || diagonal == target || anti_diagonal == target;
        }

    }

}

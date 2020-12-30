package redo.p1200_1299;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1275  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月28日  
 *  
 */
public class P1275 {

    class Solution {
        public String tictactoe(int[][] moves) {
            int player = 1;
            int[][] board = new int[3][3];
            for (int[] move : moves) {
                board[move[0]][move[1]] = player;
                player = -player;
            }
            if (isWin(board, 1)) {
                return "A";
            }
            if (isWin(board, -1)) {
                return "B";
            }
            return isAllFill(board) ? "Draw" : "Pending";
        }

        public boolean isWin(int[][] board, int player) {
            for (int i = 0; i < 3; ++i) {
                if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                    return true;
                }
            }
            for (int i = 0; i < 3; ++i) {
                if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                    return true;
                }
            }
            if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
                return true;
            }
            if (board[2][0] == player && board[1][1] == player && board[0][2] == player) {
                return true;
            }
            return false;
        }

        public boolean isAllFill(int[][] board) {
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    if (board[i][j] == 0) {
                        return false;
                    }
                }
            }
            return true;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("A", s.tictactoe(Arrs.build2D("[[0,0],[2,0],[1,1],[2,1],[2,2]]")));
        Assert.assertEquals("B", s.tictactoe(Arrs.build2D("[[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]")));
        Assert.assertEquals("Draw",
            s.tictactoe(Arrs.build2D("[[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]")));
        Assert.assertEquals("Pending", s.tictactoe(Arrs.build2D("[[0,0],[1,1]]")));
    }

}

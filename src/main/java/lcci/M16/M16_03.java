package lcci.M16;

/**  
 * @ClassName: M16_03  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月13日  
 *  
 */
public class M16_03 {
    class Solution {
        public String tictactoe(String[] board) {

            int[][] boardi = new int[board.length][board.length];

            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board.length; ++j) {
                    boardi[i][j] = board[i].charAt(j) == 'O' ? 1 : board[i].charAt(j) == 'X' ? -1 : 0;
                }
            }

            if (checkSuccess(boardi, 1)) {
                return "O";
            } else if (checkSuccess(boardi, -1)) {
                return "X";
            }

            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    if (board[i].charAt(j) == ' ') {
                        return "Pending";
                    }
                }
            }

            return "Draw";
        }

        public boolean checkSuccess(int[][] chessBoard, int num) {
            l:
            for (int i = 0; i < chessBoard.length; ++i) {
                for (int j = 0; j < chessBoard.length; ++j) {
                    if (chessBoard[i][j] != num) {
                        continue l;
                    }
                }
                return true;
            }
            l:
            for (int i = 0; i < chessBoard.length; ++i) {
                for (int j = 0; j < chessBoard.length; ++j) {
                    if (chessBoard[j][i] != num) {
                        continue l;
                    }
                }
                return true;
            }

            boolean flag = true;
            for (int i = 0; i < chessBoard.length; ++i) {
                if (chessBoard[i][i] != num) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return true;
            }

            flag = true;
            for (int i = 0; i < chessBoard.length; ++i) {
                if (chessBoard[i][chessBoard.length - 1 - i] != num) {
                    flag = false;
                    break;
                }
            }

            return flag;
        }
    }
}

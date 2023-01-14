package old._1200_1299;

public class _1275 {
	
	class Solution {
		
		public boolean checkSuccess(int[][] chessBoard, int num) {
			l: for (int i = 0; i < 3; ++i) {
				for (int j = 0; j < 3; ++j) {
					if (chessBoard[i][j] != num) {
						continue l;
					}
				}
				return true;
			}
			l: for (int i = 0; i < 3; ++i) {
				for (int j = 0; j < 3; ++j) {
					if (chessBoard[j][i] != num) {
						continue l;
					}
				}
				return true;
			}
			if (chessBoard[0][0] == num && chessBoard[1][1] == num && chessBoard[2][2] == num) {
				return true;
			}
			if (chessBoard[2][0] == num && chessBoard[1][1] == num && chessBoard[0][2] == num) {
				return true;
			}
			return false;
		}
		
		public String tictactoe(int[][] moves) {
			int[][]	chessBoard	= new int[3][3];
			int		now			= 1;
			for (int[] each : moves) {
				chessBoard[each[0]][each[1]] = now;
				if (checkSuccess(chessBoard, now)) {
					return now == 1 ? "A" : "B";
				}
				now = -now;
			}
			return moves.length == 9 ? "Draw" : "Pending";
		}
	}
	
}

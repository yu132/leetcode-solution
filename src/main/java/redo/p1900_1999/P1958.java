package redo.p1900_1999;

public class P1958 {

    class Solution {
        public boolean checkMove(char[][] board, int rMove, int cMove, char color) {

            int m = board.length, n = board[0].length;

            int[][] arr = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

            for (int dir = 0; dir < 8; ++dir) {

                int x = rMove, y = cMove, step = 0;

                while (true) {
                    x += arr[dir][0];
                    y += arr[dir][1];

                    if (!(x >= 0 && x < m && y >= 0 && y < n)) {
                        break;
                    }

                    ++step;
                    if (board[x][y] == '.') {
                        break;
                    }
                    if (board[x][y] == other(color)) {
                        continue;
                    }
                    if (board[x][y] == color) {
                        if (step >= 2) {
                            return true;
                        } else {
                            break;
                        }
                    }
                }
            }

            return false;
        }

        char other(char color) {
            if (color == 'W') {
                return 'B';
            } else {
                return 'W';
            }
        }
    }

}

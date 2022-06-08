package redo.p0900_0999;

/**  
 * @ClassName: P999  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月26日  
 *  
 */
public class P999 {

    class Solution {
        public int numRookCaptures(char[][] board) {
            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board[i].length; ++j) {
                    if (board[i][j] == 'R') {
                        int num = 0;
                        for (int x = i - 1; x >= 0; --x) {
                            if (board[x][j] == 'p') {
                                ++num;
                                break;
                            } else if (board[x][j] == 'B') {
                                break;
                            }
                        }
                        for (int x = i + 1; x < board.length; ++x) {
                            if (board[x][j] == 'p') {
                                ++num;
                                break;
                            } else if (board[x][j] == 'B') {
                                break;
                            }
                        }
                        for (int y = j - 1; y >= 0; --y) {
                            if (board[i][y] == 'p') {
                                ++num;
                                break;
                            } else if (board[i][y] == 'B') {
                                break;
                            }
                        }
                        for (int y = j + 1; y < board[0].length; ++y) {
                            if (board[i][y] == 'p') {
                                ++num;
                                break;
                            } else if (board[i][y] == 'B') {
                                break;
                            }
                        }
                        return num;
                    }
                }
            }
            return 0;
        }
    }

}

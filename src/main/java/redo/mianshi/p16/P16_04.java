package redo.mianshi.p16;

/**  
 * @ClassName: P16_04  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月15日  
 *  
 */
public class P16_04 {

    class Solution {
        public String tictactoe(String[] board) {

            int n = board.length;

            boolean draw = true;

            for (int i = 0; i < n; ++i) {
                int o = 0, x = 0;
                for (int j = 0; j < n; ++j) {
                    char ch = board[i].charAt(j);
                    if (ch == ' ') {
                        draw = false;
                        break;
                    } else if (ch == 'O') {
                        ++o;
                    } else {
                        ++x;
                    }
                }
                if (o == n) {
                    return "O";
                } else if (x == n) {
                    return "X";
                }
            }

            for (int j = 0; j < n; ++j) {
                int o = 0, x = 0;
                for (int i = 0; i < n; ++i) {
                    char ch = board[i].charAt(j);
                    if (ch == ' ') {
                        draw = false;
                        break;
                    } else if (ch == 'O') {
                        ++o;
                    } else {
                        ++x;
                    }
                }
                if (o == n) {
                    return "O";
                } else if (x == n) {
                    return "X";
                }
            }

            {
                int o = 0, x = 0;

                for (int i = 0; i < n; ++i) {

                    int j = i;

                    char ch = board[i].charAt(j);
                    if (ch == ' ') {
                        draw = false;
                        break;
                    } else if (ch == 'O') {
                        ++o;
                    } else {
                        ++x;
                    }
                }

                if (o == n) {
                    return "O";
                } else if (x == n) {
                    return "X";
                }
            }

            {
                int o = 0, x = 0;

                for (int i = 0; i < n; ++i) {

                    int j = n - i - 1;

                    char ch = board[i].charAt(j);
                    if (ch == ' ') {
                        draw = false;
                        break;
                    } else if (ch == 'O') {
                        ++o;
                    } else {
                        ++x;
                    }

                }

                if (o == n) {
                    return "O";
                } else if (x == n) {
                    return "X";
                }
            }

            if (draw) {
                return "Draw";
            }

            return "Pending";
        }
    }

}

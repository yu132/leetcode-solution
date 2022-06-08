package redo.p2000_2099;

public class P2018 {

    class Solution {
        public boolean placeWordInCrossword(char[][] board, String word) {

            int m = board.length, n = board[0].length;

            for (int i = 0; i < m; ++i) {

                StringBuilder buf = new StringBuilder(m);

                for (int j = 0; j < n; ++j) {

                    if (board[i][j] == '#') {
                        if (match(buf, word)) {
                            return true;
                        }
                        buf.delete(0, buf.length());
                    } else {
                        buf.append(board[i][j]);
                    }

                }

                if (match(buf, word)) {
                    return true;
                }

            }

            for (int j = 0; j < n; ++j) {

                StringBuilder buf = new StringBuilder(n);

                for (int i = 0; i < m; ++i) {

                    if (board[i][j] == '#') {
                        if (match(buf, word)) {
                            return true;
                        }
                        buf.delete(0, buf.length());
                    } else {
                        buf.append(board[i][j]);
                    }

                }

                if (match(buf, word)) {
                    return true;
                }

            }

            return false;
        }

        public boolean match(StringBuilder toMatch, String word) {
            return matchHelper(toMatch.toString(), word) || matchHelper(toMatch.reverse().toString(), word);
        }

        public boolean matchHelper(String toMatch, String word) {

            if (toMatch.length() != word.length()) {
                return false;
            }

            for (int i = 0; i < toMatch.length(); ++i) {
                if (toMatch.charAt(i) == ' ') {
                    continue;
                }
                if (toMatch.charAt(i) != word.charAt(i)) {
                    return false;
                }
            }

            return true;
        }
    }

}

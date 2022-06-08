package redo.p2000_2099;

public class P2075 {

    class Solution {
        public String decodeCiphertext(String encodedText, int rows) {
            if (encodedText.length() == 0) {
                return "";
            }
            StringBuilder buf = new StringBuilder(encodedText.length());
            int m = rows, n = encodedText.length() / rows;
            for (int i = 0; i <= n - m; ++i) {
                for (int j = 0; j < m; ++j) {
                    buf.append(get(encodedText, j, j + i, n));
                }
            }
            for (int i = n - m + 1, x = 1; i < n; ++i, ++x) {
                for (int j = 0; j < m - x; ++j) {
                    buf.append(get(encodedText, j, j + i, n));
                }
            }
            int index = buf.length();
            while (index > 0 && buf.charAt(index - 1) == ' ') {
                --index;
            }
            return buf.delete(index, buf.length()).toString();
        }

        char get(String str, int x, int y, int n) {
            return str.charAt(x * n + y);
        }
    }

}

package redo.p1800_1899;

public class P1861 {

    class Solution {
        public char[][] rotateTheBox(char[][] box) {

            int m = box.length, n = box[0].length;

            box = rotate(box);
            for (int i = n - 1; i >= 0; --i) {
                for (int j = 0; j < m; ++j) {
                    if (box[i][j] == '#') {
                        int k = i;
                        while (k < n - 1 && box[k + 1][j] == '.') {
                            ++k;
                        }
                        box[i][j] = '.';
                        box[k][j] = '#';
                    }
                }
            }

            return box;
        }

        public char[][] rotate(char[][] matrix) {
            char[][] arr = transposition(matrix);
            reverseInplace(arr);
            return arr;
        }

        public char[][] transposition(char[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            char[][] arr = new char[n][m];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    arr[j][i] = matrix[i][j];
                }
            }
            return arr;
        }

        public void reverseInplace(char[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n / 2; ++j) {
                    char temp = matrix[i][j];
                    matrix[i][j] = matrix[i][n - j - 1];
                    matrix[i][n - j - 1] = temp;
                }
            }
        }
    }

}

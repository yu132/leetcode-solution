package redo.Util.listAndArr;

public class IntArr2D {

    int[] flatComplete1D(int[][] arr) {
        if (arr.length == 0) {
            return new int[0];
        }
        int m = arr.length, n = arr[0].length;
        int[] flat = new int[m * n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                flat[i * n + j] = arr[i][j];
            }
        }
        return flat;
    }

    //顺时针旋转90度，不必为方阵
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

    //顺时针旋转90度，必须为方阵
    public void rotateInplace(int[][] matrix) {
        transpositionInplace(matrix);
        reverseInplace(matrix);
    }

    //矩阵转置
    public void transpositionInplace(int[][] matrix) {
        int n = matrix.length;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    //矩阵水平翻转
    public void reverseInplace(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

}

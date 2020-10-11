package lcci.M01;

/**  
 * @ClassName: M01_08  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月26日  
 *  
 */
public class M01_08 {

    class Solution {
        public void setZeroes(int[][] matrix) {

            if (matrix.length == 0) {
                return;
            }

            boolean c0 = false, r0 = false;

            for (int i = 0; i < matrix.length; ++i) {
                for (int j = 0; j < matrix[0].length; ++j) {
                    if (matrix[i][j] == 0) {

                        if (j != 0) {
                            matrix[0][j] = 0;
                        } else {
                            c0 = true;
                        }

                        if (i != 0) {
                            matrix[i][0] = 0;
                        } else {
                            r0 = true;
                        }
                    }
                }
            }

            for (int i = 1; i < matrix.length; ++i) {
                if (matrix[i][0] == 0) {
                    for (int j = 0; j < matrix[0].length; ++j) {
                        matrix[i][j] = 0;
                    }
                }
            }

            for (int j = 1; j < matrix[0].length; ++j) {
                if (matrix[0][j] == 0) {
                    for (int i = 0; i < matrix.length; ++i) {
                        matrix[i][j] = 0;
                    }
                }
            }

            if (c0) {
                for (int i = 0; i < matrix.length; ++i) {
                    matrix[i][0] = 0;
                }
            }
            if (r0) {
                for (int i = 0; i < matrix[0].length; ++i) {
                    matrix[0][i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        new M01_08().new Solution().setZeroes(new int[][] {{1, 1, 1}, {0, 1, 2}});
    }

}

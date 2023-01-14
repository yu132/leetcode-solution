package old._0900_0999;

/**  
 * @ClassName: _931  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月20日  
 *  
 */
public class _931 {

    class Solution {
        public int minFallingPathSum(int[][] A) {
            for (int i = 1; i < A.length; ++i) {
                A[i][0]               = Math.min(A[i - 1][0], A[i - 1][1]) + A[i][0];
                A[i][A[i].length - 1] =
                    Math.min(A[i - 1][A[i].length - 1], A[i - 1][A[i].length - 2]) + A[i][A[i].length - 1];
                for (int j = 1; j < A[i].length - 1; ++j) {
                    A[i][j] = Math.min(Math.min(A[i - 1][j - 1], A[i - 1][j]), A[i - 1][j + 1]) + A[i][j];
                }
            }
            int min = A[A.length - 1][0];
            for (int i = 1; i < A[A.length - 1].length; ++i) {
                min = Math.min(min, A[A.length - 1][i]);
            }
            return min;
        }
    }

}

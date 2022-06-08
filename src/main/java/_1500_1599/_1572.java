package _1500_1599;

/**  
 * @ClassName: _1572  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月8日  
 *  
 */
public class _1572 {

    class Solution {
        public int diagonalSum(int[][] mat) {
            int sum = 0;
            for (int i = 0; i < mat.length; ++i) {
                sum += mat[i][i];
                sum += mat[i][mat.length - 1 - i];
            }
            return (mat.length & 1) == 1 ? sum -= mat[mat.length / 2][mat.length / 2] : sum;
        }
    }

}

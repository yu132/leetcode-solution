package old._1500_1599;

/**  
 * @ClassName: _1582  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年10月11日  
 *  
 */
public class _1582 {

    class Solution {
        public int numSpecial(int[][] mat) {
            int[] countX = new int[mat.length];
            int[] countY = new int[mat[0].length];

            for (int i = 0; i < mat.length; ++i) {
                for (int j = 0; j < mat[i].length; ++j) {
                    if (mat[i][j] == 1) {
                        ++countX[i];
                        ++countY[j];
                    }
                }
            }

            int count = 0;
            for (int i = 0; i < mat.length; ++i) {
                for (int j = 0; j < mat[i].length; ++j) {
                    if (countX[i] == 1 && countY[j] == 1 && mat[i][j] == 1) {
                        ++count;
                    }
                }
            }

            return count;
        }
    }

}

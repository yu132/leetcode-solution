package _0300_0399;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: _311  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月10日  
 *  
 */
public class _311 {

    class Solution {
        public int[][] multiply(int[][] A, int[][] B) {

            if (B.length == 0) {
                return new int[0][0];
            }

            int[][] ans = new int[A.length][B[0].length];

            for (int i = 0; i < A.length; ++i) {
                List<Integer> notZeroIndex = new ArrayList<>();
                for (int j = 0; j < A[i].length; ++j) {
                    if (A[i][j] != 0) {
                        notZeroIndex.add(j);
                    }
                }
                for (int j = 0; j < notZeroIndex.size(); ++j) {

                    for (int k = 0; k < B[0].length; ++k) {
                        ans[i][k] += A[i][notZeroIndex.get(j)] * B[notZeroIndex.get(j)][k];
                    }

                }
            }

            return ans;
        }
    }

}

package _1000_1099;

/**  
 * @ClassName: _1043  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月21日  
 *  
 */
public class _1043 {

    class Solution {
        public int maxSumAfterPartitioning(int[] A, int K) {

            int[] res = new int[A.length];
            for (int i = 0; i < A.length; i++) {
                int domainMax = A[i];
                for (int j = 1; j <= K && i - j + 1 >= 0; j++) {
                    domainMax = Math.max(domainMax, A[i - j + 1]);
                    res[i]    = Math.max(res[i], ((i - j < 0) ? 0 : res[i - j]) + j * domainMax);
                }
            }
            return res[A.length - 1];

        }
    }

}

package _0900_0999;

/**  
 * @ClassName: _915  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月11日  
 *  
 */
public class _915 {

    class Solution {
        public int partitionDisjoint(int[] A) {
            int nowMaxLeft  = A[0];
            int toBeMaxLeft = A[0];
            int bound       = 0;
            for (int i = 1; i < A.length; ++i) {
                if (A[i] > toBeMaxLeft) {
                    toBeMaxLeft = A[i];
                } else if (A[i] < nowMaxLeft) {
                    nowMaxLeft = toBeMaxLeft;
                    bound      = i;
                }
            }
            return bound + 1;
        }
    }

}

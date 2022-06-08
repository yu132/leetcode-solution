package _1100_1199;

/**  
 * @ClassName: _1133  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月31日  
 *  
 */
public class _1133 {

    class Solution {
        public int largestUniqueNumber(int[] A) {

            int[] count = new int[1001];

            for (int i = 0; i < A.length; ++i) {
                ++count[A[i]];
            }

            for (int i = count.length - 1; i >= 0; --i) {
                if (count[i] == 1) {
                    return i;
                }
            }

            return -1;
        }
    }

}

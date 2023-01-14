package old._1000_1099;

/**  
 * @ClassName: _1085  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月31日  
 *  
 */
public class _1085 {

    class Solution {
        public int sumOfDigits(int[] A) {

            int min = A[0];

            for (int i = 1; i < A.length; ++i) {
                min = Math.min(min, A[i]);
            }

            int add = 0;

            while (min != 0) {
                add += min % 10;
                min /= 10;
            }

            return (add & 1) == 1 ? 0 : 1;
        }
    }

}

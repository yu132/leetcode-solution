package redo.p0300_0399;

/**  
 * @ClassName: P396  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月16日  
 *  
 */
public class P396 {

    class Solution {
        public int maxRotateFunction(int[] A) {
            long sum1 = sum(A);

            long sumMul = 0;

            for (int i = 1; i < A.length; ++i) {
                sumMul += i * A[i];
            }

            long max = Long.MIN_VALUE;

            for (int i = A.length - 1; i >= 0; --i) {
                sumMul -= A.length * A[i];
                sumMul += sum1;
                max = Math.max(max, sumMul);
            }

            return (int)max;
        }

        long sum(int[] nums) {
            long count = 0;
            for (int num : nums) {
                count += num;
            }
            return count;
        }
    }

}

package old._1000_1099;

import java.util.Arrays;

/**  
 * @ClassName: _1099  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月31日  
 *  
 */
public class _1099 {

    class Solution {
        public int twoSumLessThanK(int[] A, int K) {

            Arrays.sort(A);

            int max = -1;

            for (int i = 0; i < A.length; ++i) {

                int index = lowerBound(A, 0, A.length, K - A[i]);

                if (index == 0) {
                    continue;
                }

                if (index - 1 == i) {
                    continue;
                }

                max = Math.max(max, A[i] + A[index - 1]);
            }

            return max;
        }

        public int lowerBound(int[] array, int from, int size, int key) {
            int first = from, middle;
            int half, len;
            len = size;

            while (len > 0) {
                half   = len >> 1;
                middle = first + half;
                if (array[middle] < key) {
                    first = middle + 1;
                    len   = len - half - 1; // 在右边子序列中查找
                } else
                    len = half; // 在左边子序列（包含middle）中查找
            }
            return first;
        }
    }

}

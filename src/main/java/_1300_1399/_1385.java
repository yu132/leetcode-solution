package _1300_1399;

import java.util.Arrays;

/**  
 * @ClassName: _1385  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月5日  
 *  
 */
public class _1385 {

    class Solution {
        public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

            Arrays.sort(arr2);

            int count = arr1.length;

            for (int i = 0; i < arr1.length; ++i) {
                int index = lowerBound(arr2, 0, arr2.length, arr1[i]);
                if (index == arr2.length) {
                    if (Math.abs(arr1[i] - arr2[index - 1]) <= d) {
                        --count;
                    }
                } else if (index == 0) {
                    if (Math.abs(arr1[i] - arr2[index]) <= d) {
                        --count;
                    }
                } else {
                    if (Math.abs(arr1[i] - arr2[index]) <= d) {
                        --count;
                    } else if (Math.abs(arr1[i] - arr2[index - 1]) <= d) {
                        --count;
                    }
                }
            }

            return count;
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

/**
 * @Title: _1331.java
 *
 * @Package _1300_1399
 *
 * @Description: TODO(用一句话描述该文件做什么)
 *
 * @author 余定邦
 *
 * @date 2020年1月28日
 *
 */
package _1300_1399;

import java.util.Arrays;

/**
 * @ClassName: _1331
 *
 * @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author 余定邦
 *
 * @date 2020年1月28日
 * 
 */
public class _1331 {


    class Solution {

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

        public int unique(int[] array) {
            int now = 0, mid = 0;

            while (++mid != array.length)
                if (array[now] != array[mid])
                    array[++now] = array[mid];

            return now + 1;
        }

        public int[] discretize2(int[] array) {

            int[] copy = Arrays.copyOf(array, array.length);

            Arrays.sort(copy);

            int   uniqueLen        = unique(copy);

            int[] discretizedArray = new int[array.length];

            for (int i = 0; i < array.length; ++i)
                discretizedArray[i] = lowerBound(copy, 0, uniqueLen, array[i]) + 1;

            return discretizedArray;
        }

        public int[] arrayRankTransform(int[] arr) {
            if (arr.length == 0) {
                return arr;
            }
            return discretize2(arr);
        }
    }
}

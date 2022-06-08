package redo.p1000_1099;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1031  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月19日  
 *  
 */
public class P1031 {

    class Solution {
        public int maxSumTwoNoOverlap(int[] A, int L, int M) {
            return Math.max(helper(A, L, M), helper(A, M, L));
        }

        public int helper(int[] arr, int x, int y) {
            int sufSum = 0;
            for (int i = arr.length - 1; i >= arr.length - x; --i) {
                sufSum += arr[i];
            }
            // 表示此index后长为x的最大数组和
            int[] suffixMax = new int[arr.length - x + 1];
            suffixMax[arr.length - x] = sufSum;
            for (int i = arr.length - x - 1, j = arr.length - 1; i >= 0; --i, --j) {
                sufSum -= arr[j];
                sufSum += arr[i];
                suffixMax[i] = Math.max(suffixMax[i + 1], sufSum);
            }

            int max, preSum = 0;

            for (int i = 0; i < y; ++i) {
                preSum += arr[i];
            }

            max = preSum + suffixMax[y];

            for (int i = 0, j = y; j < arr.length - x; ++i, ++j) {
                preSum -= arr[i];
                preSum += arr[j];
                max = Math.max(max, preSum + suffixMax[j + 1]);
            }

            return max;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(20, s.maxSumTwoNoOverlap(new int[] {0, 6, 5, 2, 2, 5, 1, 9, 4}, 1, 2));
        Assert.assertEquals(29, s.maxSumTwoNoOverlap(new int[] {3, 8, 1, 3, 2, 1, 8, 9, 0}, 3, 2));
        Assert.assertEquals(31, s.maxSumTwoNoOverlap(new int[] {2, 1, 5, 6, 0, 9, 5, 0, 3, 8}, 4, 3));
    }

}

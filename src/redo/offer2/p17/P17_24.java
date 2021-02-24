package redo.offer2.p17;

import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.Arrs;

/**  
 * @ClassName: P17_24  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月19日  
 *  
 */
public class P17_24 {

    class Solution {
        public int[] getMaxMatrix(int[][] matrix) {

            int m = matrix.length, n = matrix[0].length;

            int x = 0, y = 0, x2 = 0, y2 = 0, max = Integer.MIN_VALUE;

            for (int i = 0; i < m; ++i) {
                int[] sum = new int[n];
                for (int k = i; k < m; ++k) {
                    for (int j = 0; j < n; ++j) {
                        sum[j] += matrix[k][j];
                    }

                    int[] ret = kadane(sum);

                    if (ret[2] > max) {
                        max = ret[2];
                        x = i;
                        x2 = k;
                        y = ret[0];
                        y2 = ret[1];
                    }
                }
            }

            return new int[] {x, y, x2, y2};
        }

        public int[] kadane(int[] arr) {
            int sum = 0, max = Integer.MIN_VALUE, start = 0, s = 0, end = 0;
            for (int i = 0; i < arr.length; ++i) {

                if (sum < 0) {
                    start = i;
                    sum = arr[i];
                } else {
                    sum += arr[i];
                }

                if (max < sum) {
                    s = start;
                    end = i;
                    max = sum;
                }

            }
            return new int[] {s, end, max};
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {0, 1, 0, 1},
            s.getMaxMatrix(Arrs.build2D("[[-1,0],[0,-1]]")));
    }

}

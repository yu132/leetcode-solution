package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P985  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月26日  
 *  
 */
public class P985 {

    class Solution {
        public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
            int[] ans = new int[queries.length];
            int evenSum = 0, index = 0;
            for (int num : A) {
                if (num % 2 == 0) {
                    evenSum += num;
                }
            }
            for (int[] querie : queries) {
                int before = A[querie[1]];
                A[querie[1]] += querie[0];

                boolean isOddBefore = Math.abs(before) % 2 == 1, isOddNow = Math.abs(A[querie[1]]) % 2 == 1;

                if (!isOddNow && isOddBefore) {
                    evenSum += A[querie[1]];
                } else if (isOddNow && !isOddBefore) {
                    evenSum -= before;
                } else if (!isOddBefore && !isOddNow) {
                    evenSum += querie[0];
                }
                ans[index++] = evenSum;
            }
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {8, 6, 2, 4},
            s.sumEvenAfterQueries(new int[] {1, 2, 3, 4}, Arrs.build2D("[[1,0],[-3,1],[-4,0],[2,3]]")));

    }

}

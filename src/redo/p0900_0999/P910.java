package redo.p0900_0999;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P910  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月25日  
 *  
 */
public class P910 {

    class Solution {
        public int smallestRangeII(int[] A, int K) {

            int n = A.length;

            Arrays.sort(A);

            int ans = A[n - 1] - A[0];

            for (int i = 0; i < A.length - 1; ++i) {
                int high = Math.max(A[n - 1] - K, A[i] + K), low = Math.min(A[0] + K, A[i + 1] - K);
                ans = Math.min(ans, high - low);
            }

            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(0, s.smallestRangeII(new int[] {1}, 0));
        Assert.assertEquals(6, s.smallestRangeII(new int[] {0, 10}, 2));
        Assert.assertEquals(3, s.smallestRangeII(new int[] {1, 3, 6}, 3));
    }

}

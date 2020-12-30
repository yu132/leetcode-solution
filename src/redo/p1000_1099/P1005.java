package redo.p1000_1099;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1005  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月26日  
 *  
 */
public class P1005 {

    class Solution {
        public int largestSumAfterKNegations(int[] A, int K) {
            Arrays.sort(A);
            for (int i = 0; i < A.length && K > 0; ++i) {
                if (A[i] < 0) {
                    A[i] = -A[i];
                    --K;
                }
            }
            int sum = 0;
            for (int num : A) {
                sum += num;
            }
            if (K % 2 == 0) {
                return sum;
            }

            Arrays.sort(A);
            int val = lowerBound(A, 0, 0, A.length);
            return sum - 2 * A[val];
        }

        public int lowerBound(int[] nums, int target, int start, int end) {
            int low = start, high = end;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(5, s.largestSumAfterKNegations(new int[] {4, 2, 3}, 1));
        Assert.assertEquals(6, s.largestSumAfterKNegations(new int[] {3, -1, 0, 2}, 3));
        Assert.assertEquals(13, s.largestSumAfterKNegations(new int[] {2, -3, -1, 5, -4}, 2));
        Assert.assertEquals(0, s.largestSumAfterKNegations(new int[] {-3, -1, 0, -2}, 1));
    }
}

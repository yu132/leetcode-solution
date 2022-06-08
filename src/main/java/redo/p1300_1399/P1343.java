package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1343  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月10日  
 *  
 */
public class P1343 {

    class Solution {
        public int numOfSubarrays(int[] arr, int k, int threshold) {
            int sum = 0, count = 0;
            for (int i = 0; i < k; ++i) {
                sum += arr[i];
            }
            if (sum >= k * threshold) {
                ++count;
            }
            for (int i = k; i < arr.length; ++i) {
                sum -= arr[i - k];
                sum += arr[i];
                if (sum >= k * threshold) {
                    ++count;
                }
            }
            return count;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.numOfSubarrays(new int[] {2, 2, 2, 2, 5, 5, 5, 8}, 3, 4));
        Assert.assertEquals(5, s.numOfSubarrays(new int[] {1, 1, 1, 1, 1}, 1, 0));
        Assert.assertEquals(6, s.numOfSubarrays(new int[] {11, 13, 17, 23, 29, 31, 7, 5, 2, 3}, 3, 5));
        Assert.assertEquals(1, s.numOfSubarrays(new int[] {7, 7, 7, 7, 7, 7, 7}, 7, 7));
        Assert.assertEquals(1, s.numOfSubarrays(new int[] {4, 4, 4, 4}, 4, 1));
    }

}

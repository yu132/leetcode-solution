package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1524  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月5日  
 *  
 */
public class P1524 {

    static//

    class Solution {

        public final static int MOD = 1000000007;

        public int numOfSubarrays(int[] arr) {
            int evenPrefix = 1, oddPrefix = 0, prefixSumNow = 0;

            long ans = 0;

            for (int num : arr) {
                prefixSumNow += num;
                if (prefixSumNow % 2 == 0) {
                    ans = (ans + oddPrefix) % MOD;
                    ++evenPrefix;
                } else {
                    ans = (ans + evenPrefix) % MOD;
                    ++oddPrefix;
                }
            }

            return (int)ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.numOfSubarrays(new int[] {1, 3, 5}));
        Assert.assertEquals(0, s.numOfSubarrays(new int[] {2, 4, 6}));
        Assert.assertEquals(16, s.numOfSubarrays(new int[] {1, 2, 3, 4, 5, 6, 7}));
        Assert.assertEquals(4, s.numOfSubarrays(new int[] {100, 100, 99, 99}));
    }

}

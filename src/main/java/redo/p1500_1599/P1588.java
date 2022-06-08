package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1588  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月30日  
 *  
 */
public class P1588 {

    class Solution {
        public int sumOddLengthSubarrays(int[] arr) {
            int[] prefix = new int[arr.length + 1];
            for (int i = 0; i < arr.length; ++i) {
                prefix[i + 1] = prefix[i] + arr[i];
            }
            int sum = 0;

            for (int i = 1; i <= arr.length; i += 2) {
                for (int j = 0; j < arr.length - i + 1; ++j) {
                    sum += prefix[j + i] - prefix[j];
                }
            }

            return sum;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(58, s.sumOddLengthSubarrays(new int[] {1, 4, 2, 5, 3}));
        Assert.assertEquals(3, s.sumOddLengthSubarrays(new int[] {1, 2}));
        Assert.assertEquals(66, s.sumOddLengthSubarrays(new int[] {10, 11, 12}));
    }

}

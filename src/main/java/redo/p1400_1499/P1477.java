package redo.p1400_1499;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1477  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月7日  
 *  
 */
public class P1477 {

    static//

    class Solution {
        public int minSumOfLengths(int[] arr, int target) {
            Map<Integer, Integer> prefixMap = new HashMap<>();
            prefixMap.put(0, -1);

            int[] minLen = new int[arr.length];
            Arrays.fill(minLen, Integer.MAX_VALUE);

            int prefixSum = 0, min = Integer.MAX_VALUE;

            for (int i = 0; i < arr.length; ++i) {
                prefixSum += arr[i];

                if (i != 0) {
                    minLen[i] = minLen[i - 1];
                }

                if (prefixMap.containsKey(prefixSum - target)) {
                    int start = prefixMap.get(prefixSum - target) + 1;
                    int end = i + 1;
                    if (start > 0 && minLen[start - 1] != Integer.MAX_VALUE) {
                        min = Math.min(min, end - start + minLen[start - 1]);
                    }
                    minLen[i] = Math.min(minLen[i], end - start);
                }

                prefixMap.put(prefixSum, i);
            }

            if (min == Integer.MAX_VALUE) {
                return -1;
            }

            return min;
        }

    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.minSumOfLengths(new int[] {3, 2, 2, 4, 3}, 3));
        Assert.assertEquals(2, s.minSumOfLengths(new int[] {7, 3, 4, 7}, 7));
        Assert.assertEquals(-1, s.minSumOfLengths(new int[] {4, 3, 2, 6, 2, 3, 4}, 6));
        Assert.assertEquals(-1, s.minSumOfLengths(new int[] {5, 5, 4, 4, 5}, 3));
        Assert.assertEquals(3, s.minSumOfLengths(new int[] {3, 1, 1, 1, 5, 1, 2, 1}, 3));
        Assert.assertEquals(-1, s.minSumOfLengths(new int[] {1, 6, 1}, 7));
    }

}

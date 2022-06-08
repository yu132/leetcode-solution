package redo.p1200_1299;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1218  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月13日  
 *  
 */
public class P1218 {

    class Solution {
        public int longestSubsequence(int[] arr, int difference) {

            Map<Integer, Integer> preLen = new HashMap<>();

            int max = 1;

            for (int num : arr) {
                if (preLen.containsKey(num - difference)) {
                    int len = preLen.remove(num - difference);
                    preLen.put(num, len + 1);
                    max = Math.max(max, len + 1);
                } else {
                    preLen.putIfAbsent(num, 1);
                }
            }

            return max;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.longestSubsequence(new int[] {1, 2, 3, 4}, 1));
        Assert.assertEquals(1, s.longestSubsequence(new int[] {1, 3, 5, 7}, 1));
        Assert.assertEquals(4, s.longestSubsequence(new int[] {1, 5, 7, 8, 5, 3, 4, 2, 1}, -2));

    }

}

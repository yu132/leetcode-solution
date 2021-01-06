package redo.p1400_1499;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1493  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月6日  
 *  
 */
public class P1493 {

    class Solution {
        public int longestSubarray(int[] nums) {
            List<Integer> len = new ArrayList<>(500);

            int lenNow = 0;
            for (int num : nums) {
                if (num == 0) {
                    len.add(lenNow);
                    lenNow = 0;
                } else {
                    ++lenNow;
                }
            }
            len.add(lenNow);

            if (len.size() == 1) {
                return nums.length - 1;
            }

            int max = 0;
            for (int i = 1; i < len.size(); ++i) {
                max = Math.max(max, len.get(i - 1) + len.get(i));
            }

            return max;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.longestSubarray(new int[] {1, 1, 0, 1}));
        Assert.assertEquals(5, s.longestSubarray(new int[] {0, 1, 1, 1, 0, 1, 1, 0, 1}));
        Assert.assertEquals(2, s.longestSubarray(new int[] {1, 1, 1}));
        Assert.assertEquals(4, s.longestSubarray(new int[] {1, 1, 0, 0, 1, 1, 1, 0, 1}));
        Assert.assertEquals(0, s.longestSubarray(new int[] {0, 0, 0}));
        Assert.assertEquals(0, s.longestSubarray(new int[] {0}));
    }

}

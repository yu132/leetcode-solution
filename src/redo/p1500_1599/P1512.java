package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1512  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1512 {

    static//

    class Solution {
        public int numIdenticalPairs(int[] nums) {
            int[] count = count(nums, 1, 101);
            int ans = 0;
            for (int i = 0; i < count.length; ++i) {
                ans += count[i] * (count[i] - 1) / 2;
            }
            return ans;
        }

        public static int[] count(int[] nums, int start, int end) {
            int[] count = new int[end - start];
            for (int num : nums) {
                ++count[num - start];
            }
            return count;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.numIdenticalPairs(new int[] {1, 2, 3, 1, 1, 3}));
        Assert.assertEquals(6, s.numIdenticalPairs(new int[] {1, 1, 1, 1}));
        Assert.assertEquals(0, s.numIdenticalPairs(new int[] {1, 2, 3}));
    }

}

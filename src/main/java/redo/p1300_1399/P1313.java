package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1313  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月28日  
 *  
 */
public class P1313 {

    class Solution {
        public int[] decompressRLElist(int[] nums) {
            int len = 0;
            for (int i = 0; i < nums.length; i += 2) {
                len += nums[i];
            }
            int[] ans = new int[len];
            int index = 0;
            for (int i = 0; i < nums.length; i += 2) {
                for (int j = 0; j < nums[i]; ++j) {
                    ans[index++] = nums[i + 1];
                }
            }
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {2, 4, 4, 4}, s.decompressRLElist(new int[] {1, 2, 3, 4}));
        Assert.assertArrayEquals(new int[] {1, 3, 3}, s.decompressRLElist(new int[] {1, 1, 2, 3}));
    }
}

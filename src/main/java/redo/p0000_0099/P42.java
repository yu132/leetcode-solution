package redo.p0000_0099;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P42  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月4日  
 *  
 */
public class P42 {

    class Solution {
        public int trap(int[] height) {
            int n = height.length;
            int[] maxL = new int[n], maxR = new int[n];
            int max = 0;
            for (int i = 0; i < n; ++i) {
                maxL[i] = max;
                max = Math.max(max, height[i]);
            }
            max = 0;
            for (int i = n - 1; i >= 0; --i) {
                maxR[i] = max;
                max = Math.max(max, height[i]);
            }
            int ans = 0;
            for (int i = 0; i < n; ++i) {
                ans += Math.max(Math.min(maxL[i], maxR[i]) - height[i], 0);
            }
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(6,
            s.trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        Assert.assertEquals(9, s.trap(new int[] {4, 2, 0, 3, 2, 5}));
    }

}

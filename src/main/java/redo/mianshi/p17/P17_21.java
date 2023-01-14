package redo.mianshi.p17;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P17_21  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月18日  
 *  
 */
public class P17_21 {

    class Solution {
        public int trap(int[] height) {
            int n = height.length;
            int[] left = new int[n], right = new int[n];

            int max = 0;

            for (int i = 0; i < n; ++i) {
                max = Math.max(max, height[i]);
                left[i] = max;
            }

            max = 0;

            for (int i = n - 1; i >= 0; --i) {
                max = Math.max(max, height[i]);
                right[i] = max;
            }

            int count = 0;

            for (int i = 0; i < n; ++i) {
                count += Math.max(0, Math.min(left[i], right[i]) - height[i]);
            }

            return count;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(6,
            s.trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

}

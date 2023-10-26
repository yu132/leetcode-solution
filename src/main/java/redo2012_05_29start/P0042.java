package redo2012_05_29start;

/**  
 * @ClassName: P042  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年6月5日  
 *  
 */
public class P0042 {

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
            int ans = 0;
            for (int i = 0; i < n; ++i) {
                ans += Math.min(left[i], right[i]) - height[i];
            }
            return ans;
        }
    }

}
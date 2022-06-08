package redo.p0000_0099;

/**  
 * @ClassName: P11  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月21日  
 *  
 */
public class P11 {

    class Solution {
        public int maxArea(int[] height) {
            int low = 0, high = height.length - 1, max = 0;
            while (low < high) {
                max = Math.max(max,
                    (high - low) * Math.min(height[low], height[high]));
                if (height[low] >= height[high]) {
                    --high;
                } else {
                    ++low;
                }
            }
            return max;
        }
    }

}

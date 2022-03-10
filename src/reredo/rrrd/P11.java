package reredo.rrrd;

/**  
 * @ClassName: P11  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月24日  
 *  
 */
public class P11 {

    class Solution {
        public int maxArea(int[] height) {
            int low = 0, high = height.length - 1;

            int max = 0;

            while (low < high) {
                max = Math.max(max,
                    (high - low) * Math.min(height[high], height[low]));
                if (height[high] >= height[low]) {
                    ++low;
                } else {
                    --high;
                }
            }

            return max;
        }
    }

}

package redo.p0100_0199;

/**  
 * @ClassName: P62  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月23日  
 *  
 */
public class P162 {

    class Solution {
        public int findPeakElement(int[] nums) {
            int low = 0, high = nums.length - 1;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (nums[mid] > nums[mid + 1]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }

}

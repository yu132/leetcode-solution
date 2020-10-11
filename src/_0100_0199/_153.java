package _0100_0199;

/**  
 * @ClassName: _153  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月12日  
 *  
 */
public class _153 {

    class Solution {
        public int findMin(int[] nums) {
            int low = 0, high = nums.length;
            while (true) {
                if (low >= high) {
                    return nums[low];
                }
                int mid = (low + high) >>> 1;
                if (nums[mid] > nums[nums.length - 1]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
        }
    }

}

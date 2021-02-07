package redo.offer;

/**  
 * @ClassName: P53_1  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P53_2 {

    class Solution {
        public int missingNumber(int[] nums) {

            if (nums.length - 1 == nums[nums.length - 1]) {
                return nums.length;
            }

            int low = 0, high = nums.length - 1;

            while (low < high) {
                int mid = (low + high) >>> 1;
                if (nums[mid] == mid) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            return low;
        }
    }

}

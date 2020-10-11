package lcof;

/**  
 * @ClassName: M53_2  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月22日  
 *  
 */
public class M53_2 {

    class Solution {
        public int missingNumber(int[] nums) {
            if (nums[nums.length - 1] == nums.length - 1) {
                return nums.length;
            }
            int low = 0, high = nums.length - 1;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (nums[mid] != mid) {// left
                    high = mid;
                } else {// right
                    low = mid + 1;
                }
            }
            return low;
        }
    }

}

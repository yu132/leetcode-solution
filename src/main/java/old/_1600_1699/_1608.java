package old._1600_1699;

import java.util.Arrays;

/**  
 * @ClassName: _1608  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年10月17日  
 *  
 */
public class _1608 {

    class Solution {
        public int specialArray(int[] nums) {
            Arrays.sort(nums);

            if (nums[nums.length - 1] < 1) {
                return -1;
            }

            for (int i = 1; i < nums.length; ++i) {
                if (nums[nums.length - i] >= i && nums[nums.length - i - 1] < i) {
                    return i;
                } else if (nums[nums.length - i - 1] == i) {
                    return -1;
                }
            }

            return nums.length;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 4, 3, 0, 4};
        System.out.println(new _1608().new Solution().specialArray(arr));
    }
}

package _0000_0099;

/**  
 * @ClassName: _80  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月11日  
 *  
 */
public class _80 {

    class Solution {
        public int removeDuplicates(int[] nums) {
            boolean flag = true;
            int     j    = 1;
            for (int i = 1; i < nums.length; ++i) {
                if (nums[i - 1] == nums[i]) {
                    if (flag) {
                        flag      = false;
                        nums[j++] = nums[i];
                    }
                } else {
                    flag      = true;
                    nums[j++] = nums[i];
                }
            }
            return j;
        }
    }

}

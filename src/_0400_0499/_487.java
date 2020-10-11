package _0400_0499;

/**  
 * @ClassName: _487  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月17日  
 *  
 */
public class _487 {

    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {

            int indexOf0 = -1, start = 0, max = 0;

            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] == 0) {
                    indexOf0 = i;
                    break;
                }
            }

            if (indexOf0 == -1) {
                return nums.length;
            }

            for (int i = indexOf0 + 1; i < nums.length; ++i) {
                if (nums[i] == 0) {
                    max      = Math.max(max, i - start);
                    start    = indexOf0 + 1;
                    indexOf0 = i;
                }
            }

            max = Math.max(max, nums.length - start);

            return max;
        }
    }

}

package redo.offer2.p17;

/**  
 * @ClassName: P17_10  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月16日  
 *  
 */
public class P17_10 {

    class Solution {
        public int majorityElement(int[] nums) {
            if (nums.length == 0) {
                return -1;
            }
            int num = nums[0], count = 1;
            for (int i = 1; i < nums.length; ++i) {
                if (count == 0) {
                    num = nums[i];
                    count = 1;
                    continue;
                }
                if (nums[i] == num) {
                    ++count;
                } else {
                    --count;
                }
            }

            count = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (num == nums[i]) {
                    ++count;
                }
            }

            return count * 2 > nums.length ? num : -1;
        }
    }

}

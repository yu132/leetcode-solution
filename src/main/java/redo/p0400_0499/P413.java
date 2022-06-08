package redo.p0400_0499;

/**  
 * @ClassName: P413  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月16日  
 *  
 */
public class P413 {

    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {

            if (nums.length < 3) {
                return 0;
            }

            int diff = nums[1] - nums[0], len = 2, count = 0;

            for (int i = 2; i < nums.length; ++i) {
                if (diff != nums[i] - nums[i - 1]) {
                    count += count(len);
                    len = 2;
                    diff = nums[i] - nums[i - 1];
                } else {
                    ++len;
                }
            }

            count += count(len);

            return count;
        }

        int count(int len) {
            return (len - 1) * (len - 2) / 2;
        }
    }

}

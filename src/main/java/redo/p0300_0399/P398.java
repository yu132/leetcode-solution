package redo.p0300_0399;

import java.util.concurrent.ThreadLocalRandom;

/**  
 * @ClassName: P398  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月25日  
 *  
 */
public class P398 {

    class Solution {

        int[] nums;

        ThreadLocalRandom r = ThreadLocalRandom.current();

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int pick(int target) {
            int index = -1, count = 0;

            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] == target) {
                    ++count;
                    if (r.nextInt(count) == 0) {
                        index = i;
                    }
                }
            }

            return index;
        }
    }

}

package reredo.rrrd;

import java.util.Deque;
import java.util.LinkedList;

/**  
 * @ClassName: P456  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月24日  
 *  
 */
public class P456 {

    static//

    class Solution {
        public boolean find132pattern(int[] nums) {

            int n = nums.length;

            Deque<Data> mstack = new LinkedList<>();

            for (int i = 0, min = Integer.MAX_VALUE; i < n; ++i) {
                while (!mstack.isEmpty() && mstack.peek().val <= nums[i]) {
                    mstack.pop();
                }
                if (!mstack.isEmpty() && mstack.peek().min < nums[i]) {
                    return true;
                }
                min = Math.min(min, nums[i]);
                mstack.push(new Data(nums[i], min));
            }

            return false;
        }

        static class Data {
            int val, min;

            public Data(int val, int min) {
                super();
                this.val = val;
                this.min = min;
            }
        }
    }

}

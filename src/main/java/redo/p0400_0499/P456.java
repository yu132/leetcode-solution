package redo.p0400_0499;

import java.util.Deque;
import java.util.LinkedList;

/**  
 * @ClassName: P456  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月22日  
 *  
 */
public class P456 {

    class Solution {
        public boolean find132pattern(int[] nums) {

            if (nums.length < 3) {
                return false;
            }

            int[] min = new int[nums.length];
            min[0] = nums[0];

            Deque<Integer> mstack = new LinkedList<>();

            for (int i = 1; i < nums.length; ++i) {
                min[i] = Math.min(min[i - 1], nums[i]);
            }

            for (int i = nums.length - 1; i >= 0; --i) {
                if (nums[i] == min[i]) {
                    continue;
                }
                while (!mstack.isEmpty() && mstack.peek() <= min[i]) {
                    mstack.pop();
                }
                if (!mstack.isEmpty() && mstack.peek() < nums[i]) {
                    return true;
                }
                mstack.push(nums[i]);
            }
            return false;
        }
    }

}

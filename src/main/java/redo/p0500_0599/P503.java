package redo.p0500_0599;

import java.util.Deque;
import java.util.LinkedList;

/**  
 * @ClassName: P503  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月25日  
 *  
 */
public class P503 {

    static//

    class Solution {
        public int[] nextGreaterElements(int[] nums) {

            Deque<Data> mstack = new LinkedList<>();

            int[] ans = new int[nums.length];

            for (int i = 0; i < nums.length; ++i) {
                while (!mstack.isEmpty() && mstack.peek().val < nums[i]) {
                    ans[mstack.pop().index] = nums[i];
                }
                mstack.push(new Data(i, nums[i]));
            }

            for (int i = 0; i < nums.length; ++i) {
                while (!mstack.isEmpty() && mstack.peek().val < nums[i]) {
                    ans[mstack.pop().index] = nums[i];
                }
            }

            while (!mstack.isEmpty()) {
                ans[mstack.pop().index] = -1;
            }

            return ans;
        }

        static class Data {
            int index, val;

            public Data(int index, int val) {
                super();
                this.index = index;
                this.val = val;
            }
        }
    }

}

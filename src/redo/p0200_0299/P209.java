package redo.p0200_0299;

import java.util.Deque;
import java.util.LinkedList;

/**  
 * @ClassName: P209  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月28日  
 *  
 */
public class P209 {

    class Solution {
        public int minSubArrayLen(int target, int[] nums) {

            int preSum = 0, ans = Integer.MAX_VALUE;

            Deque<Data> mqueue = new LinkedList<>();

            mqueue.offerLast(new Data(0, -1));

            for (int i = 0; i < nums.length; ++i) {
                preSum += nums[i];
                while (!mqueue.isEmpty()
                    && mqueue.peekLast().preSum >= preSum) {
                    mqueue.pollLast();
                }
                while (!mqueue.isEmpty()
                    && mqueue.peekFirst().preSum + target <= preSum) {
                    ans = Math.min(ans, i - mqueue.pollFirst().index);
                }
                mqueue.offerLast(new Data(i, preSum));
            }

            if (ans == Integer.MAX_VALUE) {
                return 0;
            }

            return ans;
        }

        class Data {
            int index, preSum;

            public Data(int index, int preSum) {
                super();
                this.index = index;
                this.preSum = preSum;
            }
        }
    }

}

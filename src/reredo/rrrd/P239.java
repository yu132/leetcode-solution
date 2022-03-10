package reredo.rrrd;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**  
 * @ClassName: P239  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月24日  
 *  
 */
public class P239 {

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {

            Deque<Integer> mqueue = new ArrayDeque<>(k);

            int n = nums.length;

            int[] ans = new int[n - k + 1];

            for (int i = 0; i < k; ++i) {
                while (!mqueue.isEmpty() && mqueue.peekLast() < nums[i]) {
                    mqueue.pollLast();
                }
                mqueue.offerLast(nums[i]);
            }

            for (int i = k; i < n; ++i) {
                ans[i - k] = mqueue.peekFirst();
                if (mqueue.peekFirst() == nums[i - k]) {
                    mqueue.pollFirst();
                }
                while (!mqueue.isEmpty() && mqueue.peekLast() < nums[i]) {
                    mqueue.pollLast();
                }
                mqueue.offer(nums[i]);
            }

            ans[n - k] = mqueue.peekFirst();

            return ans;
        }
    }

}

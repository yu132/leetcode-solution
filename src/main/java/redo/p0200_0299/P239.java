package redo.p0200_0299;

import java.util.Deque;
import java.util.LinkedList;

/**  
 * @ClassName: P239  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P239 {

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {

            if (nums.length == 0) {
                return new int[0];
            }

            Deque<Integer> mqueue = new LinkedList<>();

            int[] ans = new int[nums.length - k + 1];
            int low = 0, high = k;

            for (int i = low; i < high; ++i) {
                while (!mqueue.isEmpty() && mqueue.peekLast() < nums[i]) {
                    mqueue.pollLast();
                }
                mqueue.offerLast(nums[i]);
            }

            ans[0] = mqueue.peekFirst();

            for (; high < nums.length; ++low, ++high) {
                if (nums[low] == mqueue.peekFirst()) {
                    mqueue.pollFirst();
                }
                while (!mqueue.isEmpty() && mqueue.peekLast() < nums[high]) {
                    mqueue.pollLast();
                }
                mqueue.offerLast(nums[high]);
                ans[low + 1] = mqueue.peekFirst();
            }

            return ans;
        }
    }

}

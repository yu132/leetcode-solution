package _0200_0299;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**  
 * @ClassName: _239  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月23日  
 *  
 */
public class _239 {

    class Solution {
        class Node {
            int num;
            int index;

            public Node(int num, int index) {
                super();
                this.num   = num;
                this.index = index;
            }
        }

        public int[] maxSlidingWindow(int[] nums, int k) {

            if (nums.length == 0) {
                return new int[0];
            }

            Deque<Node> mq    = new LinkedList<>();
            int         index = 0;

            for (int i = 0; i < k - 1; ++i) {
                mq(mq, nums[i], index++, k);
            }

            int[] ans = new int[nums.length - k + 1];

            for (int i = k - 1; i < nums.length; ++i) {
                ans[i - k + 1] = mq(mq, nums[i], index++, k);
            }

            return ans;
        }

        public int mq(Deque<Node> mq, int num, int index, int len) {
            while (!mq.isEmpty() && mq.getLast().num <= num) {
                mq.removeLast();
            }
            mq.addLast(new Node(num, index));
            while (index - mq.getFirst().index >= len) {
                mq.removeFirst();
            }
            return mq.getFirst().num;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _239().new Solution().maxSlidingWindow(new int[] {}, 2)));
    }
}

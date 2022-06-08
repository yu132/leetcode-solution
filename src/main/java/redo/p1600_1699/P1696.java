package redo.p1600_1699;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1696  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月31日  
 *  
 */
public class P1696 {

    static//

    class Solution {
        public int maxResult(int[] nums, int k) {
            int[] dp = new int[nums.length];
            Arrays.fill(dp, Integer.MIN_VALUE);
            dp[0] = nums[0];
            Deque<Data> queue = new LinkedList<>();
            queue.addLast(new Data(nums[0], 0));
            for (int i = 1; i < nums.length; ++i) {
                while (queue.peekFirst().index < i - k) {
                    queue.removeFirst();
                }
                dp[i] = queue.peekFirst().value + nums[i];
                while (!queue.isEmpty() && queue.peekLast().value < dp[i]) {
                    queue.removeLast();
                }
                queue.addLast(new Data(dp[i], i));
            }
            return dp[dp.length - 1];
        }

        static class Data {
            int value;
            int index;

            public Data(int value, int index) {
                super();
                this.value = value;
                this.index = index;
            }
        }
    }

    // class Solution {
    // public int maxResult(int[] nums, int k) {
    // int[] dp = new int[nums.length];
    // Arrays.fill(dp, Integer.MIN_VALUE);
    // dp[0] = nums[0];
    // PriorityQueue<Data> maxQueue = new PriorityQueue<>((a, b) -> Integer.compare(b.value, a.value));
    // maxQueue.offer(new Data(nums[0], 0));
    // for (int i = 1; i < nums.length; ++i) {
    // while (maxQueue.peek().index < i - k) {
    // maxQueue.poll();
    // }
    // dp[i] = maxQueue.peek().value + nums[i];
    // maxQueue.offer(new Data(dp[i], i));
    // }
    // return dp[dp.length - 1];
    // }
    //
    // static class Data {
    // int value;
    // int index;
    //
    // public Data(int value, int index) {
    // super();
    // this.value = value;
    // this.index = index;
    // }
    // }
    // }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(7, s.maxResult(new int[] {1, -1, -2, 4, -7, 3}, 2));
        Assert.assertEquals(17, s.maxResult(new int[] {10, -5, -2, 4, 0, 3}, 3));
        Assert.assertEquals(0, s.maxResult(new int[] {1, -5, -20, 4, -1, 3, -6, -3}, 2));
    }
}

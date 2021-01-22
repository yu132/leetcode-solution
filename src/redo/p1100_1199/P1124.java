package redo.p1100_1199;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1124  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月15日  
 *  
 */
public class P1124 {

    static//

    class Solution {
        public int longestWPI(int[] hours) {
            for (int i = 0; i < hours.length; ++i) {
                if (hours[i] > 8) {
                    hours[i] = 1;
                } else {
                    hours[i] = -1;
                }
            }
            return maxSubArrGreaterThanK(hours, 0);
        }

        static int maxSubArrGreaterThanK(int[] nums, int k) {
            return maxWidthRampVariant(prefix(nums), k);
        }

        public static int[] prefix(int[] nums) {
            int[] prefix = new int[nums.length + 1];
            for (int i = 0; i < nums.length; ++i) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
            return prefix;
        }

        // 和一般的最大宽坡有条件上的不同
        static int maxWidthRampVariant(int[] nums, int k) {
            SimpleIntArrayDeque queue = new SimpleIntArrayDeque(nums.length);
            for (int i = 0; i < nums.length; ++i) {
                if (queue.isEmpty() || nums[queue.peekLast()] > nums[i]) {
                    queue.offerLast(i);
                }
            }
            int ans = 0;
            for (int i = nums.length - 1; i >= 0 && !queue.isEmpty(); --i) {
                while (!queue.isEmpty() && nums[i] - nums[queue.peekLast()] > k) {
                    ans = Math.max(ans, i - queue.pollLast());
                }
            }
            return ans;
        }

        static class SimpleIntArrayDeque {

            int start = 0, end = 0, deque[];

            public SimpleIntArrayDeque(int len) {
                super();
                this.deque = new int[len];
            }

            public void offerLast(int num) {
                deque[end++] = num;
            }

            public int pollLast() {
                return deque[--end];
            }

            public int peekLast() {
                return deque[end - 1];
            }

            public int pollFirst() {
                return deque[start++];
            }

            public int peekFirst() {
                return deque[start];
            }

            public boolean isEmpty() {
                return start == end;
            }

            public int size() {
                return end - start;
            }

            public void clear() {
                start = end = 0;
            }
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.longestWPI(new int[] {9, 9, 6, 0, 6, 6, 9}));
        Assert.assertEquals(3, s.longestWPI(new int[] {0, 0, 0, 0, 9, 6, 9}));
        Assert.assertEquals(5, s.longestWPI(new int[] {6, 6, 9, 9, 9}));
        Assert.assertEquals(5, s.longestWPI(new int[] {6, 9, 9, 9, 6}));
    }

}

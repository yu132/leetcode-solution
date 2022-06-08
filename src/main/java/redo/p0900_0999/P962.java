package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P962  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月15日  
 *  
 */
public class P962 {

    static//

    class Solution {
        public int maxWidthRamp(int[] A) {
            return maxWidthRampH(A);
        }

        static int maxWidthRampH(int[] nums) {
            SimpleIntArrayDeque queue = new SimpleIntArrayDeque(nums.length);
            for (int i = 0; i < nums.length; ++i) {
                if (queue.isEmpty() || nums[queue.peekLast()] > nums[i]) {
                    queue.offerLast(i);
                }
            }
            int ans = 0;
            for (int i = nums.length - 1; i >= 0; --i) {
                while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
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
        Assert.assertEquals(4, s.maxWidthRamp(new int[] {6, 0, 8, 2, 1, 5}));
        Assert.assertEquals(7, s.maxWidthRamp(new int[] {9, 8, 1, 0, 1, 9, 4, 0, 4, 1}));
    }

}

package redo.Util.ag.array.maxWidthRamp;

/**  
 * @ClassName: MaxWidthRamp  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月15日  
 *  
 */
public class MaxWidthRampUtil {

    // test by leetcode-962
    static int maxWidthRamp(int[] nums) {
        SimpleIntArrayDeque queue = new SimpleIntArrayDeque(nums.length);
        for (int i = 0; i < nums.length; ++i) {
            if (queue.isEmpty() || nums[queue.peekLast()] > nums[i]) {
                queue.offerLast(i);
            }
        }
        int ans = 0;
        for (int i = nums.length - 1; i >= 0; --i) {

            // 注意题目给定的是nums[i]<=nums[j]还是nums[i]<nums[j]，符号要和下面的符号一致
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

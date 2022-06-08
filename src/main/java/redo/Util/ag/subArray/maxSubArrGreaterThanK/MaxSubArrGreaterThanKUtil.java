package redo.Util.ag.subArray.maxSubArrGreaterThanK;

/**  
 * @ClassName: MaxSubArrGreaterThanN  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月15日  
 *  
 */
public class MaxSubArrGreaterThanKUtil {

    // test by leetcode-1124
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

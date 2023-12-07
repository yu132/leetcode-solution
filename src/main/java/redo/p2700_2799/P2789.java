package redo.p2700_2799;

import java.util.LinkedList;

public class P2789 {

    class Solution {
        public long maxArrayValue(int[] nums) {
            LinkedList<Long> stack = new LinkedList<>();
            stack.push((long) nums[nums.length - 1]);
            for (int i = nums.length - 2; i >= 0; --i) {
                if (stack.peek() >= nums[i]) {
                    stack.push(stack.pop() + nums[i]);
                } else {
                    stack.push((long) nums[i]);
                }
            }
            long max = 0;
            while (!stack.isEmpty()) {
                max = Math.max(max, stack.pop());
            }
            return max;
        }
    }

}

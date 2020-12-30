package redo.p0400_0499;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.junit.Test;

/**  
 * @ClassName: P496  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P496 {

    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Map<Integer, Integer> nextBigger = new HashMap<>();
            Deque<Integer> stack = new LinkedList<>();

            for (int num : nums2) {
                while (!stack.isEmpty() && num > stack.peek()) {
                    nextBigger.put(stack.pop(), num);
                }
                stack.push(num);
            }

            for (int i = 0; i < nums1.length; ++i) {
                nums1[i] = nextBigger.getOrDefault(nums1[i], -1);
            }

            return nums1;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {-1, 3, -1}, s.nextGreaterElement(new int[] {4, 1, 2}, new int[] {1, 3, 4, 2}));
        assertArrayEquals(new int[] {3, -1}, s.nextGreaterElement(new int[] {2, 4}, new int[] {1, 2, 3, 4}));

    }

}

package redo.p0400_0499;

import static org.junit.jupiter.api.Assertions.*;

import java.util.PriorityQueue;

import org.junit.Test;

/**  
 * @ClassName: P414  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P414 {

    class Solution {
        public int thirdMax(int[] nums) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int num : nums) {
                if (pq.contains(num)) {
                    continue;
                }
                if (pq.size() < 3) {
                    pq.offer(num);
                } else {
                    pq.offer(num);
                    pq.poll();
                }
            }
            if (pq.size() == 3) {
                return pq.poll();
            } else {
                while (pq.size() != 1) {
                    pq.poll();
                }
                return pq.peek();
            }
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.thirdMax(new int[] {3, 2, 1}));
        assertEquals(2, s.thirdMax(new int[] {2, 1}));
        assertEquals(1, s.thirdMax(new int[] {2, 2, 3, 1}));
        assertEquals(2, s.thirdMax(new int[] {1, 1, 2}));
    }

}

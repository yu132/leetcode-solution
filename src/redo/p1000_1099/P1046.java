package redo.p1000_1099;

import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1046  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月26日  
 *  
 */
public class P1046 {

    class Solution {
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
            for (int num : stones) {
                pq.offer(num);
            }
            while (pq.size() > 1) {
                int a = pq.poll(), b = pq.poll();
                if (a != b) {
                    pq.offer(Math.abs(a - b));
                }
            }
            return pq.size() == 0 ? 0 : pq.poll();
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.lastStoneWeight(new int[] {2, 7, 4, 1, 8, 1}));
        Assert.assertEquals(0, s.lastStoneWeight(new int[] {2, 2}));
    }

}

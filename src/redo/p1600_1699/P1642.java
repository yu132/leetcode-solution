package redo.p1600_1699;

import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1642  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月2日  
 *  
 */
public class P1642 {

    class Solution {
        public int furthestBuilding(int[] heights, int bricks, int ladders) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
            for (int i = 1; i < heights.length; ++i) {
                if (heights[i - 1] >= heights[i]) {
                    continue;
                }
                int diff = heights[i] - heights[i - 1];
                if (bricks >= diff) {
                    bricks -= diff;
                    pq.offer(diff);
                } else {
                    if (ladders == 0) {
                        return i - 1;
                    }
                    pq.offer(diff);
                    int maxDiff = pq.poll();
                    --ladders;
                    bricks += maxDiff - diff;
                }
            }
            return heights.length - 1;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.furthestBuilding(new int[] {4, 2, 7, 6, 9, 14, 12}, 5, 1));
        Assert.assertEquals(7, s.furthestBuilding(new int[] {4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2));
        Assert.assertEquals(3, s.furthestBuilding(new int[] {14, 3, 19, 3}, 17, 0));
    }

}

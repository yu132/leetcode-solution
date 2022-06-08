package redo.p1600_1699;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1631  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月3日  
 *  
 */
public class P1631 {

    static//

    class Solution {
        public int minimumEffortPath(int[][] heights) {
            PriorityQueue<Data> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
            Set<Integer> visited = new HashSet<>();
            pq.offer(new Data(0, 0, 0));
            int maxCost = 0;
            while (true) {
                Data data = pq.poll();
                visited.add(data.x + 101 * data.y);
                maxCost = Math.max(maxCost, data.cost);
                if (data.x == heights.length - 1 && data.y == heights[0].length - 1) {
                    break;
                }
                getCost(data.x, data.y, data.x - 1, data.y, heights, visited, pq);
                getCost(data.x, data.y, data.x + 1, data.y, heights, visited, pq);
                getCost(data.x, data.y, data.x, data.y - 1, heights, visited, pq);
                getCost(data.x, data.y, data.x, data.y + 1, heights, visited, pq);
            }
            return maxCost;
        }

        static void getCost(int x, int y, int x1, int y1, int[][] heights, Set<Integer> visited,
            PriorityQueue<Data> pq) {
            if (x1 < 0 || y1 < 0 || x1 >= heights.length || y1 >= heights[0].length
                || visited.contains(x1 + 101 * y1)) {
                return;
            }
            pq.offer(new Data(x1, y1, Math.abs(heights[x][y] - heights[x1][y1])));
        }

        static class Data {
            int x, y, cost;

            public Data(int x, int y, int cost) {
                super();
                this.x = x;
                this.y = y;
                this.cost = cost;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.minimumEffortPath(Arrs.build2D("[[1,2,2],[3,8,2],[5,3,5]]")));
        Assert.assertEquals(1, s.minimumEffortPath(Arrs.build2D("[[1,2,3],[3,8,4],[5,3,5]]")));
        Assert.assertEquals(0,
            s.minimumEffortPath(Arrs.build2D("[[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]")));
    }
}

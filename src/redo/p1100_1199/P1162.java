package redo.p1100_1199;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1162  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月14日  
 *  
 */
public class P1162 {

    static//

    class Solution {
        public int maxDistance(int[][] grid) {
            Deque<Visit> queue = new LinkedList<>();
            int m = grid.length, n = grid[0].length;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == 1) {// 多源bfs
                        queue.offer(new Visit(i + 1, j, -1));
                        queue.offer(new Visit(i - 1, j, -1));
                        queue.offer(new Visit(i, j + 1, -1));
                        queue.offer(new Visit(i, j - 1, -1));
                    }
                }
            }
            int max = 0;
            while (!queue.isEmpty()) {
                Visit visit = queue.poll();
                if (visit.x < 0 || visit.x >= m || visit.y < 0 || visit.y >= n) {
                    continue;
                }
                if (grid[visit.x][visit.y] == 1) {
                    continue;
                }
                if (grid[visit.x][visit.y] != 0 && grid[visit.x][visit.y] >= visit.dis) {
                    continue;
                }
                grid[visit.x][visit.y] = visit.dis;
                max = Math.min(max, visit.dis);
                queue.offer(new Visit(visit.x + 1, visit.y, visit.dis - 1));
                queue.offer(new Visit(visit.x - 1, visit.y, visit.dis - 1));
                queue.offer(new Visit(visit.x, visit.y + 1, visit.dis - 1));
                queue.offer(new Visit(visit.x, visit.y - 1, visit.dis - 1));
            }
            return max == 0 ? -1 : -max;
        }

        static class Visit {
            int x, y, dis;

            public Visit(int x, int y, int dis) {
                super();
                this.x = x;
                this.y = y;
                this.dis = dis;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.maxDistance(Arrs.build2D("[[1,0,1],[0,0,0],[1,0,1]]")));
        Assert.assertEquals(4, s.maxDistance(Arrs.build2D("[[1,0,0],[0,0,0],[0,0,0]]")));
        Assert.assertEquals(-1, s.maxDistance(Arrs.build2D("[[0,0,0],[0,0,0],[0,0,0]]")));
        Assert.assertEquals(-1, s.maxDistance(Arrs.build2D("[[1,1,1],[1,1,1],[1,1,1]]")));
    }

}

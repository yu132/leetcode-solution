package redo.p1000_1099;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1091  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月15日  
 *  
 */
public class P1091 {

    static//

    class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            Deque<Pair> queue = new LinkedList<>();
            queue.offer(new Pair(0, 0, 1));
            int m = grid.length, n = grid[0].length;
            while (!queue.isEmpty()) {
                Pair p = queue.poll();
                if (p.x < 0 || p.x >= m || p.y < 0 || p.y >= n) {
                    continue;
                }
                if (grid[p.x][p.y] == 1) {
                    continue;
                }
                if (p.x == m - 1 && p.y == n - 1) {
                    return p.level;
                }
                grid[p.x][p.y] = 1;// 不准回头
                queue.offer(new Pair(p.x + 1, p.y, p.level + 1));
                queue.offer(new Pair(p.x - 1, p.y, p.level + 1));
                queue.offer(new Pair(p.x, p.y + 1, p.level + 1));
                queue.offer(new Pair(p.x, p.y - 1, p.level + 1));
                queue.offer(new Pair(p.x + 1, p.y + 1, p.level + 1));
                queue.offer(new Pair(p.x + 1, p.y - 1, p.level + 1));
                queue.offer(new Pair(p.x - 1, p.y + 1, p.level + 1));
                queue.offer(new Pair(p.x - 1, p.y - 1, p.level + 1));
            }
            return -1;
        }

        static class Pair {
            int x, y, level;

            public Pair(int x, int y, int level) {
                super();
                this.x = x;
                this.y = y;
                this.level = level;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.shortestPathBinaryMatrix(Arrs.build2D("[[0,1],[1,0]]")));
        Assert.assertEquals(4, s.shortestPathBinaryMatrix(Arrs.build2D("[[0,0,0],[1,1,0],[1,1,0]]")));
    }

}

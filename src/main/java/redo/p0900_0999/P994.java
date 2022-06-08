package redo.p0900_0999;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P994  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月20日  
 *  
 */
public class P994 {

    class Solution {
        public int orangesRotting(int[][] grid) {

            int m = grid.length, n = grid[0].length;

            Deque<Data> queue = new LinkedList<>();

            int fresh = 0;

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == 1) {
                        ++fresh;
                    } else if (grid[i][j] == 2) {
                        queue.offer(new Data(i + 1, j, 1));
                        queue.offer(new Data(i - 1, j, 1));
                        queue.offer(new Data(i, j + 1, 1));
                        queue.offer(new Data(i, j - 1, 1));
                    }
                }
            }

            int minTime = 0;

            while (!queue.isEmpty()) {

                Data data = queue.poll();

                if (data.x < 0 || data.x >= m || data.y < 0 || data.y >= n) {
                    continue;
                }

                if (grid[data.x][data.y] == 1) {

                    --fresh;

                    grid[data.x][data.y] = 2;
                    minTime = data.time;

                    queue.offer(new Data(data.x + 1, data.y, data.time + 1));
                    queue.offer(new Data(data.x - 1, data.y, data.time + 1));
                    queue.offer(new Data(data.x, data.y + 1, data.time + 1));
                    queue.offer(new Data(data.x, data.y - 1, data.time + 1));
                }
            }

            if (fresh > 0) {
                return -1;
            }

            return minTime;
        }


        class Data {
            int x, y, time;

            public Data(int x, int y, int time) {
                super();
                this.x = x;
                this.y = y;
                this.time = time;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.orangesRotting(Arrs.build2D("[[2,1,1],[1,1,0],[0,1,1]]")));
        Assert.assertEquals(-1, s.orangesRotting(Arrs.build2D("[[2,1,1],[0,1,1],[1,0,1]]")));
        Assert.assertEquals(0, s.orangesRotting(Arrs.build2D("[[0,2]]")));
    }

}

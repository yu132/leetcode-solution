package redo.p0900_0999;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P909  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月22日  
 *  
 */
public class P909 {

    static//

    class Solution {
        public int snakesAndLadders(int[][] board) {
            int n = board.length;
            Deque<Index> queue = new LinkedList<>();
            queue.offer(new Index(n - 1, 0));
            int time = 0, size = 1;

            int tx, ty;// 目标
            if (n % 2 == 0) {
                tx = 0;
                ty = 0;
            } else {
                tx = 0;
                ty = n - 1;
            }

            boolean[][] visited = new boolean[n][n];

            while (!queue.isEmpty()) {
                Index index = queue.poll();

                --size;

                int x = index.x, y = index.y;

                if (visited[x][y]) {

                    if (size == 0) {
                        ++time;
                        size = queue.size();
                    }

                    continue;
                }

                visited[x][y] = true;

                for (int i = 1; i <= 6; ++i) {

                    int diff = n - 1 - x;
                    if (diff % 2 == 0) {
                        ++y;
                    } else {
                        --y;
                    }

                    if (y == -1) {
                        y = 0;
                        --x;
                    } else if (y == n) {
                        y = n - 1;
                        --x;
                    }

                    if (board[x][y] != -1) {
                        int tranX = n - 1 - (board[x][y] - 1) / n,
                            tranY = ((n - 1 - tranX) % 2 == 0 ? (board[x][y] - 1) % n : n - 1 - (board[x][y] - 1) % n);

                        if (tranX == tx && tranY == ty) {
                            return time + 1;
                        }

                        queue.offer(new Index(tranX, tranY));
                    } else {
                        if (x == tx && y == ty) {
                            return time + 1;
                        }

                        queue.offer(new Index(x, y));
                    }
                }

                if (size == 0) {
                    ++time;
                    size = queue.size();
                }
            }

            return -1;
        }

        static class Index {
            int x, y;

            public Index(int x, int y) {
                super();
                this.x = x;
                this.y = y;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.snakesAndLadders(Arrs.build2D(
            "[[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]")));

        Assert.assertEquals(1, s.snakesAndLadders(Arrs.build2D("[[-1,-1,-1],[-1,9,8],[-1,8,9]]")));

        Assert.assertEquals(1, s.snakesAndLadders(Arrs.build2D("[[-1,-1,2,-1],[14,2,12,3],[4,9,1,11],[-1,2,1,16]]")));

        Assert.assertEquals(3, s.snakesAndLadders(Arrs.build2D(
            "[[-1,5,-1,-1,17,6,-1],[41,28,-1,-1,-1,27,-1],[35,42,-1,-1,-1,-1,4],[7,32,-1,25,-1,43,-1],[-1,26,5,-1,-1,-1,25],[28,-1,-1,5,-1,-1,41],[-1,42,28,25,-1,7,28]]")));

        Assert.assertEquals(3, s.snakesAndLadders(Arrs.build2D(
            "[[-1,33,-1,-1,-1,-1,-1,-1],[5,-1,-1,-1,-1,49,-1,-1],[-1,-1,-1,31,-1,-1,54,43],[-1,-1,26,13,41,-1,-1,-1],[-1,-1,-1,-1,14,45,23,2],[30,33,-1,-1,-1,-1,31,-1],[17,49,-1,-1,-1,-1,-1,-1],[-1,56,12,47,-1,-1,-1,-1]]")));
    }

}

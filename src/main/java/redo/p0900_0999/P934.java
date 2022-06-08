package redo.p0900_0999;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.Arrs;

/**  
 * @ClassName: P934  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月22日  
 *  
 */
public class P934 {

    static//

    /*
     * [[1,1,1,1,1],
     *  [1,0,0,0,1],
     *  [1,0,1,0,1],
     *  [1,0,0,0,1],
     *  [1,1,1,1,1]]
     *  
     *  [[0,0,0,0,0,0,0,0,0],
     *   [0,0,0,0,0,0,0,0,0],
     *   [0,0,0,0,0,0,0,0,1],
     *   [0,0,0,0,0,0,0,1,1],
     *   [0,0,0,0,0,0,0,1,1],
     *   [0,0,0,0,0,0,0,0,1],
     *   [0,1,0,0,0,0,0,0,0],
     *   [1,1,1,0,0,0,0,0,0],
     *   [1,1,0,0,0,0,0,0,0]]
     */

    class Solution {
        public int shortestBridge(int[][] A) {
            Deque<Index> queue = new LinkedList<>();

            int n = A.length;

            int[][] visited = new int[n][n];

            boolean first = true;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (A[i][j] == 1) {
                        if (first) {
                            first = false;
                            dfs(i, j, n, 1, queue, A);
                        } else {
                            dfs(i, j, n, -1, queue, A);
                        }
                    }
                }
            }

            while (true) {
                Index i = queue.poll();
                if (i.x < 0 || i.x >= n || i.y < 0 || i.y >= n) {
                    continue;
                }

                if (visited[i.x][i.y] == 0) {
                    visited[i.x][i.y] = i.dis;
                } else if ((visited[i.x][i.y] ^ i.dis) < 0) {
                    return Math.abs(visited[i.x][i.y] - i.dis) - 1;
                } else {
                    continue;
                }

                queue.offer(new Index(i.x + 1, i.y, i.baseDis + i.dis, i.baseDis));
                queue.offer(new Index(i.x - 1, i.y, i.baseDis + i.dis, i.baseDis));
                queue.offer(new Index(i.x, i.y + 1, i.baseDis + i.dis, i.baseDis));
                queue.offer(new Index(i.x, i.y - 1, i.baseDis + i.dis, i.baseDis));
            }
        }

        void dfs(int x, int y, int n, int baseDis, Deque<Index> queue, int[][] A) {
            if (x < 0 || x >= n || y < 0 || y >= n) {
                return;
            }
            if (A[x][y] == 0) {
                return;
            }
            A[x][y] = 0;
            queue.offer(new Index(x, y, 0, baseDis));
            dfs(x + 1, y, n, baseDis, queue, A);
            dfs(x - 1, y, n, baseDis, queue, A);
            dfs(x, y + 1, n, baseDis, queue, A);
            dfs(x, y - 1, n, baseDis, queue, A);
        }

        static class Index {
            int x, y, dis, baseDis;

            public Index(int x, int y, int dis, int baseDis) {
                super();
                this.x = x;
                this.y = y;
                this.dis = dis;
                this.baseDis = baseDis;
            }
        }
    }

    // class Solution {
    // public int shortestBridge(int[][] A) {
    // Deque<Index> queue = new LinkedList<>();
    //
    // int n = A.length;
    //
    // int[][] visited = new int[n][n];
    //
    // boolean first = true;
    // for (int i = 0; i < n; ++i) {
    // for (int j = 0; j < n; ++j) {
    // if (A[i][j] == 1) {
    // if (first) {
    // first = false;
    // dfs(i, j, n, 1, queue, A, new boolean[n][n]);
    // } else {
    // dfs(i, j, n, -1, queue, A, new boolean[n][n]);
    // }
    // }
    // }
    // }
    //
    // int a = 1;
    //
    // while (true) {
    // Index i = queue.poll();
    // if (i.x < 0 || i.x >= n || i.y < 0 || i.y >= n) {
    // continue;
    // }
    //
    // // System.out.println(i.x + " " + i.y);
    //
    // if ((visited[i.x][i.y] < 0 && i.dis > 0) || (visited[i.x][i.y] > 0 && i.dis < 0)) {
    // System.out.println(visited[i.x][i.y] + " " + i.dis);
    // return Math.abs(visited[i.x][i.y] - i.dis) - 1;
    // } else if (visited[i.x][i.y] != 0) {
    // continue;
    // } else if (A[i.x][i.y] != 1) {
    // visited[i.x][i.y] = i.dis;
    // }
    //
    // queue.offer(new Index(i.x + 1, i.y, i.baseDis + i.dis, i.baseDis));
    // queue.offer(new Index(i.x - 1, i.y, i.baseDis + i.dis, i.baseDis));
    // queue.offer(new Index(i.x, i.y + 1, i.baseDis + i.dis, i.baseDis));
    // queue.offer(new Index(i.x, i.y - 1, i.baseDis + i.dis, i.baseDis));
    // }
    // }
    //
    // void dfs(int x, int y, int n, int baseDis, Deque<Index> queue, int[][] A, boolean[][] visited) {
    // if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y] || A[x][y] != 1) {
    // return;
    // }
    // System.out.println(x + " " + y);
    // visited[x][y] = true;
    // queue.offer(new Index(x, y, 0, baseDis));
    // dfs(x + 1, y, n, baseDis, queue, A, visited);
    // dfs(x - 1, y, n, baseDis, queue, A, visited);
    // dfs(x, y + 1, n, baseDis, queue, A, visited);
    // dfs(x, y - 1, n, baseDis, queue, A, visited);
    // }
    //
    // static class Index {
    // int x, y, dis, baseDis;
    //
    // public Index(int x, int y, int dis, int baseDis) {
    // super();
    // this.x = x;
    // this.y = y;
    // this.dis = dis;
    // this.baseDis = baseDis;
    // }
    // }
    // }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.shortestBridge(Arrs.build2D("[[0,1],[1,0]]")));
        Assert.assertEquals(2, s.shortestBridge(Arrs.build2D("[[0,1,0],[0,0,0],[0,0,1]]")));
        Assert.assertEquals(1,
            s.shortestBridge(Arrs.build2D("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]")));
        Assert.assertEquals(7, s.shortestBridge(Arrs.build2D(
            "[[0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,1],[0,0,0,0,0,0,0,1,1],[0,0,0,0,0,0,0,1,1],[0,0,0,0,0,0,0,0,1],[0,1,0,0,0,0,0,0,0],[1,1,1,0,0,0,0,0,0],[1,1,0,0,0,0,0,0,0]]")));
    }

}

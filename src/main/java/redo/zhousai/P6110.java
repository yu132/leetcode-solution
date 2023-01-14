package redo.zhousai;

import redo.testUtil.Arrs;

import java.util.*;

public class P6110 {

    class Solution {

        public final static int MOD = 1_000_000_007;

        public int countPaths(int[][] grid) {
            int m = grid.length, n = grid[0].length, total = m * n;
            int[][] dir = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
            List<Integer>[] adjac = new List[total];
            int[] in = new int[total];
            Arrays.setAll(adjac, x -> new ArrayList<>());
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    for (int k = 0; k < dir.length; ++k) {
                        int x = i + dir[k][0], y = j + dir[k][1];
                        if (x < 0 || x >= m || y < 0 || y >= n) {
                            continue;
                        }
                        if (grid[x][y] < grid[i][j]) {
                            adjac[index(i, j, n)].add(index(x, y, n));
                            ++in[index(x, y, n)];
                        }
                    }
                }
            }
            long[] dp = new long[total];
            Arrays.fill(dp, 1);
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < in.length; ++i) {
                if (in[i] == 0) {
                    q.offer(i);
                }
            }
            while (!q.isEmpty()) {
                int node = q.poll();
                for (int child : adjac[node]) {
                    dp[child] = (dp[child] + dp[node]) % MOD;
                    --in[child];
                    if (in[child] == 0) {
                        q.offer(child);
                    }
                }
            }
            long ans = 0;
            for (int i = 0; i < dp.length; ++i) {
                ans = (ans + dp[i]) % MOD;
            }
            return (int) ans;
        }

        int index(int i, int j, int n) {
            return i * n + j;
        }
    }

    public static void main(String[] args) {
        new P6110().new Solution().countPaths(Arrs.build2D("[[1,1],[3,4]]"));

        {
            AbstractList a;
            ArrayList b;
            LinkedList c;
            Object[] d = new Number[1];
        }
        {
            Object[] a = new Number[1];
            a[0] = new Object();//运行时抛出ArrayStoreException
        }
        {
            List a = new ArrayList();
            a.add(new Integer(0));
            Integer x = (Integer) a.get(0);

            List<Integer> b = new ArrayList<>();
            b.add(new Integer(0));
            Integer y = b.get(0);
        }

        {
            int a, b, c;
            a = b = c = 1;
            a = (b = (c = 1));
        }

        {
            outer:
            for (int i = 0; i < 10; ++i) {
                for (int j = 0; j < 10; ++j) {
                    break outer;
                }
            }
        }

        {

        }
    }

    class A {
        B b;
    }

    class B {
        A a;
    }

}

package redo.p1900_1999;

public class P1947 {

    class Solution {
        public int maxCompatibilitySum(int[][] students, int[][] mentors) {
            int n = students.length;
            int[][] w = new int[n + 1][n + 1];

            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    int count = 0;
                    for (int k = 0; k < students[0].length; ++k) {
                        if (students[i][k] == mentors[j][k]) {
                            ++count;
                        }
                    }
                    w[i + 1][j + 1] = count;
                }
            }

            return new KmHelper(n, w).km();
        }

        class KmHelper {

            int n;//最多图的点数

            int inf = (int) 1e9 + 7;//若求最小权值匹配，应该为-1e9+7;
            int[][] w;//边权
            int[] la, lb;//左、右部点的顶标
            boolean[] va, vb;//访问标记，是否在交错树中
            int[] match;//右部点匹配的左部点（一个只能匹配一个嘛）
            int delta;
            int[] upd;
            int[] p, c;

            // n 为两个图的大小，不知不相等是否可行，w需要为1-n（包含）的一一映射
            // 这个模板的作者不喜欢0，还是由于什么特殊的原因，w需要从1开始
            public KmHelper(int n, int[][] w) {
                this.n = n;
                n = n + 1;
                this.w = w;
                this.la = new int[n];
                this.lb = new int[n];
                this.va = new boolean[n];
                this.vb = new boolean[n];
                this.match = new int[n];
                this.upd = new int[n];
                this.p = new int[n];
                this.c = new int[n];
            }

            void bfs(int x) {
                int a, y = 0, y1 = 0;

                for (int i = 1; i <= n; ++i) {
                    p[i] = 0;
                    c[i] = inf;
                }
                match[y] = x;
                do {
                    a = match[y];
                    delta = inf;
                    vb[y] = true;
                    for (int b = 1; b <= n; ++b) {
                        if (!vb[b]) {
                            if (c[b] > la[a] + lb[b] - w[a][b]) {
                                c[b] = la[a] + lb[b] - w[a][b];
                                p[b] = y;
                            }
                            if (c[b] < delta) {//Δ还是取最小的
                                delta = c[b];
                                y1 = b;
                            }
                        }
                    }
                    for (int b = 0; b <= n; ++b) {
                        if (vb[b]) {
                            la[match[b]] -= delta;
                            lb[b] += delta;
                        } else {
                            c[b] -= delta;
                        }
                    }
                    y = y1;
                } while (match[y] != 0);
                while (y != 0) {
                    match[y] = match[p[y]];
                    y = p[y];
                }
            }

            int km() {
                for (int i = 1; i <= n; ++i) {
                    match[i] = la[i] = lb[i] = 0;
                }
                for (int i = 1; i <= n; ++i) {
                    for (int j = 1; j <= n; ++j) {
                        vb[j] = false;
                    }
                    bfs(i);
                }
                int res = 0;
                for (int y = 1; y <= n; ++y) {//若匹配失败w[match[y]][y]=INF;
                    res += w[match[y]][y];
                }
                return res;
            }
        }
    }

}

package redo.Util.ag.binaryGraph;

/**
 * KM算法，用于解决二分图的最优匹配问题
 * <p>
 * 即二分图中需要为两组中的元素进行配对，一个组元素只能配对另一个组中的一个元素，成功配对的元素能提供一定的值，求配对形成的最大值
 *
 * @see redo.p1900_1999.P1947
 */
public class KM {

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
        // 如果图大小不相等，可以补齐一方的大小，并令补齐的w[i][j]为0即可
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

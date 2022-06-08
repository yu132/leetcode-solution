package redo.Util.ds.segmentTree;

import org.junit.Test;

/**  
 * @ClassName: ZkwSegmentTreeUtil  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月16日  
 *  
 */
public class ZkwSegmentTreeUtil {

    /*
     * m：非叶子节点数
     * n：总叶子节点数
     * 
     * 有bug，没法用
     */

    class ZkwSegmentTree {

        int m;
        int[] mn, mx, sum, add;

        ZkwSegmentTree(int[] data) {

            for (m = 1; m <= data.length; m <<= 1);

            mn = new int[2 * m];
            mx = new int[2 * m];
            sum = new int[2 * m];
            add = new int[2 * m];

            build(data);
        }

        private void build(int[] data) {

            for (int i = m + 1; i <= m + data.length; ++i) {
                sum[i] = mn[i] = mx[i] = data[i - (m + 1)];
            }
            for (int i = m - 1; i != 0; --i) {
                sum[i] = sum[i << 1] + sum[i << 1 | 1];

                mn[i] = Math.min(mn[i << 1], mn[i << 1 | 1]);
                mn[i << 1] -= mn[i];
                mn[i << 1 | 1] -= mn[i];

                mx[i] = Math.max(mx[i << 1], mx[i << 1 | 1]);
                mx[i << 1] -= mx[i];
                mx[i << 1 | 1] -= mx[i];
            }
        }

        void update(int x, int v) {
            int A = 0;

            x += m;
            mx[x] += v;
            mn[x] += v;

            for (; x > 1; x >>= 1) {

                sum[x] += v;

                A = Math.min(mn[x], mn[x ^ 1]);
                mn[x] -= A;
                mn[x ^ 1] -= A;
                mn[x >> 1] += A;

                A = Math.max(mx[x], mx[x ^ 1]);
                mx[x] -= A;
                mx[x ^ 1] -= A;
                mx[x >> 1] += A;
            }
        }

        void updateRange(int s, int t, int v) {
            int A = 0, lc = 0, rc = 0, len = 1;
            for (s += m - 1, t += m + 1; (s ^ t ^ 1) != 0; s >>= 1, t >>= 1, len <<= 1) {
                if ((s & 1 ^ 1) != 0) {
                    add[s ^ 1] += v;
                }

                lc += len;
                mn[s ^ 1] += v;
                mx[s ^ 1] += v;
                if ((t & 1) != 0) {
                    add[t ^ 1] += v;
                }

                rc += len;
                mn[t ^ 1] += v;
                mx[t ^ 1] += v;

                sum[s >> 1] += v * lc;
                sum[t >> 1] += v * rc;

                A = Math.min(mn[s], mn[s ^ 1]);
                mn[s] -= A;
                mn[s ^ 1] -= A;
                mn[s >> 1] += A;

                A = Math.min(mn[t], mn[t ^ 1]);
                mn[t] -= A;
                mn[t ^ 1] -= A;
                mn[t >> 1] += A;

                A = Math.max(mx[s], mx[s ^ 1]);
                mx[s] -= A;
                mx[s ^ 1] -= A;
                mx[s >> 1] += A;

                A = Math.max(mx[t], mx[t ^ 1]);
                mx[t] -= A;
                mx[t ^ 1] -= A;
                mx[t >> 1] += A;
            }

            for (lc += rc; s > 1; s >>= 1) {
                sum[s >> 1] += v * lc;

                A = Math.min(mn[s], mn[s ^ 1]);
                mn[s] -= A;
                mn[s ^ 1] -= A;
                mn[s >> 1] += A;

                A = Math.max(mx[s], mx[s ^ 1]);
                mx[s] -= A;
                mx[s ^ 1] -= A;
                mx[s >> 1] += A;
            }
        }

        int query(int x) {
            int ans = 0;
            for (x += m; x != 0; x >>= 1) {
                ans += mn[x];
            }
            return ans;
        }

        int querySum(int s, int t) {
            int lc = 0, rc = 0, len = 1, ans = 0;
            for (s += m - 1, t += m + 1; (s ^ t ^ 1) != 0; s >>= 1, t >>= 1, len <<= 1) {
                if ((s & 1 ^ 1) != 0) {
                    ans += sum[s ^ 1] + len * add[s ^ 1];
                    lc += len;
                }
                if ((t & 1) != 0) {
                    ans += sum[t ^ 1] + len * add[t ^ 1];
                    rc += len;
                }

                if (add[s >> 1] != 0) {
                    ans += add[s >> 1] * lc;
                }

                if (add[t >> 1] != 0) {
                    ans += add[t >> 1] * rc;
                }
            }
            for (lc += rc, s >>= 1; s != 0; s >>= 1) {
                if (add[s] != 0) {
                    ans += add[s] * lc;
                }
            }
            return ans;
        }

        int queryMin(int s, int t) {
            if (s == t) {
                return query(s);
            }
            int L = 0, R = 0, ans = 0;
            for (s += m, t += m; (s ^ t ^ 1) != 0; s >>= 1, t >>= 1) { // 这里 s 和 t 直接加上 m
                L += mn[s];
                R += mn[t];
                if ((s & 1 ^ 1) != 0) {
                    L = Math.min(L, mn[s ^ 1]);
                }
                if ((t & 1) != 0) {
                    R = Math.min(R, mn[t ^ 1]);
                }
            }
            for (ans = Math.min(L, R), s >>= 1; s != 0; s >>= 1) {
                ans += mn[s];
            }
            return ans;
        }

        int queryMax(int s, int t) {
            if (s == t) {
                return query(s);
            }
            int L = 0, R = 0, ans = 0;
            for (s += m, t += m; (s ^ t ^ 1) != 0; s >>= 1, t >>= 1) {
                L += mx[s];
                R += mx[t];
                if ((s & 1 ^ 1) != 0) {
                    L = Math.max(L, mx[s ^ 1]);
                }
                if ((t & 1) != 0) {
                    R = Math.max(R, mx[t ^ 1]);
                }
            }
            for (ans = Math.max(L, R), s >>= 1; s != 0; s >>= 1) {
                ans += mx[s];
            }
            return ans;
        }
    }



    @Test
    public void test() {

        int[] data = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};


    }

}

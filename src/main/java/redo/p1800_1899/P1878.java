package redo.p1800_1899;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class P1878 {

    class Solution {
        public int[] getBiggestThree(int[][] grid) {

            int m = grid.length, n = grid[0].length;

            int[][] preSumLeftDown = new int[m + 1][n + 2],
                    preSumRightDown = new int[m + 1][n + 2];

            TopDistinctMaintainer<Integer> topMaintainer = new TopDistinctMaintainer<>(3);

            for (int i = 1; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    preSumLeftDown[i][j] = preSumLeftDown[i - 1][j + 1] + grid[i - 1][j - 1];
                    preSumRightDown[i][j] = preSumRightDown[i - 1][j - 1] + grid[i - 1][j - 1];
                }
            }

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    topMaintainer.put(grid[i][j]);
                    for (int k = i + 2; k < m; k += 2) {
                        int ux = i, uy = j;
                        int dx = k, dy = j;
                        int lx = (i + k) / 2, ly = j - (k - i) / 2;
                        int rx = (i + k) / 2, ry = j + (k - i) / 2;
                        if (ly < 0 || ry >= n) {
                            break;
                        }
                        topMaintainer.put(
                                (preSumLeftDown[lx + 1][ly + 1] - preSumLeftDown[ux][uy + 2]) +
                                        (preSumRightDown[rx + 1][ry + 1] - preSumRightDown[ux][uy]) +
                                        (preSumRightDown[dx + 1][dy + 1] - preSumRightDown[lx][ly]) +
                                        (preSumLeftDown[dx + 1][dy + 1] - preSumLeftDown[rx][ry + 2]) -
                                        (grid[ux][uy] + grid[dx][dy] + grid[lx][ly] + grid[rx][ry])
                        );
                    }
                }
            }

            return topMaintainer.pq.stream().sorted(Collections.reverseOrder()).mapToInt(x -> x).toArray();
        }

        class TopDistinctMaintainer<E extends Comparable<E>> {

            PriorityQueue<E> pq;

            Set<E> set;

            int k;

            public TopDistinctMaintainer(int k) {
                this.k = k;
                pq = new PriorityQueue<>(k);
                set = new HashSet<>(k);
            }

            public void put(E element) {
                if (set.contains(element)) {
                    return;
                }
                if (pq.size() >= k) {
                    if (element.compareTo(pq.peek()) > 0) {
                        set.remove(pq.poll());
                    } else {
                        return;
                    }
                }
                pq.offer(element);
                set.add(element);
            }
        }
    }

}

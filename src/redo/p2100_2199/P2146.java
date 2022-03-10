package redo.p2100_2199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class P2146 {

    class Solution {
        public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
            int m = grid.length, n = grid[0].length;

            boolean[][] visited = new boolean[m][n];

            LinkedList<Location> queue = new LinkedList<>();
            queue.offer(new Location(start[0], start[1], 0, grid));

            PriorityQueue<Location> pq = new PriorityQueue<>(k);

            while (!queue.isEmpty()) {
                Location loc = queue.poll();
                int x = loc.x, y = loc.y;
                if (x < 0 || x >= m || y < 0 || y >= n) {
                    continue;
                }
                if (grid[x][y] == 0) {
                    continue;
                }
                if (visited[x][y]) {
                    continue;
                }
                visited[x][y] = true;

                if (pricing[0] <= grid[x][y] && grid[x][y] <= pricing[1]) {
                    if (pq.size() < k) {
                        pq.offer(loc);
                    } else {
                        if (pq.peek().compareTo(loc) < 0) {
                            pq.poll();
                            pq.offer(loc);
                        }
                    }
                }

                queue.offer(new Location(x + 1, y, loc.dis + 1, grid));
                queue.offer(new Location(x - 1, y, loc.dis + 1, grid));
                queue.offer(new Location(x, y + 1, loc.dis + 1, grid));
                queue.offer(new Location(x, y - 1, loc.dis + 1, grid));
            }

            LinkedList<List<Integer>> ans = new LinkedList<>();
            while (!pq.isEmpty()) {
                Location loc = pq.poll();
                List<Integer> list = new ArrayList<>();
                list.add(loc.x);
                list.add(loc.y);
                ans.offerFirst(list);
            }
            return ans;
        }

        class Location implements Comparable<Location> {
            int x, y, dis;
            int[][] grid;

            public Location(int x, int y, int dis, int[][] grid) {
                this.x = x;
                this.y = y;
                this.dis = dis;
                this.grid = grid;
            }

            @Override
            public int compareTo(Location o) {
                if (dis != o.dis) {
                    return Integer.compare(o.dis, dis);
                }
                if (grid[x][y] != grid[o.x][o.y]) {
                    return Integer.compare(grid[o.x][o.y], grid[x][y]);
                }
                if (x != o.x) {
                    return Integer.compare(o.x, x);
                }
                return Integer.compare(o.y, y);
            }
        }
    }

}

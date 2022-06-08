package redo.p1900_1999;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P1905 {

    class Solution {
        public int countSubIslands(int[][] grid1, int[][] grid2) {

            Island NULL = new Island();

            int m = grid1.length, n = grid1[0].length;

            Map<Point, Island> mapping = new HashMap<>();
            boolean[][] visited1 = new boolean[m][n], visited2 = new boolean[m][n];

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (visited1[i][j]) {
                        continue;
                    }
                    if (grid1[i][j] == 1) {
                        toIsland(visited1, i, j, mapping, grid1);
                    }
                }
            }

            int ans = 0;

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (visited2[i][j]) {
                        continue;
                    }
                    if (grid2[i][j] == 1) {
                        Island island = toIsland(visited2, i, j, null, grid2);
                        Island mayContained = mapping.getOrDefault(new Point(i, j), NULL);
                        if (mayContained.contains(island)) {
                            ++ans;
                        }
                    }
                }
            }

            return ans;
        }

        Island toIsland(boolean[][] visited, int startX, int startY, Map<Point, Island> mapping, int[][] grid) {
            Island island = new Island();
            helper(visited, startX, startY, island, mapping, grid);
            return island;
        }

        void helper(boolean[][] visited, int x, int y, Island island, Map<Point, Island> mapping, int[][] grid) {
            if (x < 0 || x >= visited.length || y < 0 || y >= visited[0].length) {
                return;
            }
            if (grid[x][y] == 0) {
                return;
            }
            if (visited[x][y]) {
                return;
            }
            visited[x][y] = true;
            Point p = new Point(x, y);
            island.add(p);
            if (mapping != null) {
                mapping.put(p, island);
            }
            helper(visited, x + 1, y, island, mapping, grid);
            helper(visited, x - 1, y, island, mapping, grid);
            helper(visited, x, y + 1, island, mapping, grid);
            helper(visited, x, y - 1, island, mapping, grid);
        }

        class Island {
            Set<Point> points = new HashSet<>();

            void add(Point point) {
                points.add(point);
            }

            boolean contains(Island other) {
                for (Point p : other.points) {
                    if (!points.contains(p)) {
                        return false;
                    }
                }
                return true;
            }
        }

        class Point {
            int x, y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Point point = (Point) o;
                return x == point.x &&
                        y == point.y;
            }

            @Override
            public int hashCode() {
                return x + 501 * y;
            }
        }
    }

}

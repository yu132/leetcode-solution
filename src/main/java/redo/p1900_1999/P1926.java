package redo.p1900_1999;

import java.util.LinkedList;

public class P1926 {

    class Solution {
        public int nearestExit(char[][] maze, int[] entrance) {

            int m = maze.length, n = maze[0].length;

            LinkedList<Node> queue = new LinkedList<>();
            queue.offer(new Node(entrance[0], entrance[1], 0));

            boolean[][] visited = new boolean[m][n];

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                if (node.x < 0 || node.y < 0 || node.x >= m || node.y >= n) {
                    continue;
                }
                if (maze[node.x][node.y] == '+') {
                    continue;
                }
                if (visited[node.x][node.y]) {
                    continue;
                }
                visited[node.x][node.y] = true;
                if (isBoundary(node.x, node.y, m, n) && (entrance[0] != node.x || entrance[1] != node.y)) {
                    return node.dis;
                }
                queue.offer(new Node(node.x + 1, node.y, node.dis + 1));
                queue.offer(new Node(node.x - 1, node.y, node.dis + 1));
                queue.offer(new Node(node.x, node.y + 1, node.dis + 1));
                queue.offer(new Node(node.x, node.y - 1, node.dis + 1));
            }

            return -1;
        }

        boolean isBoundary(int x, int y, int m, int n) {
            return x == 0 || y == 0 || x == m - 1 || y == n - 1;
        }

        class Node {
            int x, y, dis;

            public Node(int x, int y, int dis) {
                this.x = x;
                this.y = y;
                this.dis = dis;
            }
        }
    }

}

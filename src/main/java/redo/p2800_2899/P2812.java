package redo.p2800_2899;

import redo.testUtil.Arrs;

import java.util.*;

public class P2812 {

    class Solution {
        public int maximumSafenessFactor(List<List<Integer>> grid) {

            int[] dir = new int[]{-1, 0, 1, 0, -1};

            int[][] gridArr = cv(grid);

            int n = gridArr.length;

            Set<Integer> visited = new HashSet<>();
            LinkedList<Node> queue = new LinkedList<>();
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (gridArr[i][j] == 1) {
                        queue.offer(new Node(i, j, 0));
                    }
                }
            }
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                if (visited.contains(get(node.x, node.y))) {
                    continue;
                }
                gridArr[node.x][node.y] = node.dis;
                visited.add(get(node.x, node.y));
                for (int d = 1; d < dir.length; ++d) {
                    int newX = node.x + dir[d - 1], newY = node.y + dir[d];
                    if (newX < 0 || newX >= n || newY < 0 || newY >= n || visited.contains(get(newX, newY))) {
                        continue;
                    }
                    queue.offer(new Node(newX, newY, node.dis + 1));
                }
            }
            PriorityQueue<Node1> pq = new PriorityQueue<>(Comparator.comparingInt(x -> -x.sort));
            pq.offer(new Node1(n - 1, n - 1, gridArr[n - 1][n - 1]));

            visited.clear();
            while (!pq.isEmpty()) {
                Node1 node = pq.poll();
                if (visited.contains(get(node.x, node.y))) {
                    continue;
                }
                visited.add(get(node.x, node.y));
                if (node.x == 0 && node.y == 0) {
                    return node.sort;
                }
                for (int d = 1; d < dir.length; ++d) {
                    int newX = node.x + dir[d - 1], newY = node.y + dir[d];
                    if (newX < 0 || newX >= n || newY < 0 || newY >= n || visited.contains(get(newX, newY))) {
                        continue;
                    }
                    pq.offer(new Node1(newX, newY, Math.min(node.sort, gridArr[newX][newY])));
                }
            }
            return -1;
        }

        class Node1 {
            int x, y, sort;

            public Node1(int x, int y, int sort) {
                this.x = x;
                this.y = y;
                this.sort = sort;
            }
        }

        class Node {
            int x, y, dis;

            public Node(int x, int y, int dis) {
                this.x = x;
                this.y = y;
                this.dis = dis;
            }
        }


        int get(int x, int y) {
            return x * 401 + y;
        }

        int[][] cv(List<List<Integer>> list) {
            int[][] outer = new int[list.size()][];
            for (int i = 0; i < list.size(); ++i) {
                List<Integer> innerList = list.get(i);
                int[] inner = new int[innerList.size()];
                for (int j = 0; j < innerList.size(); ++j) {
                    inner[j] = innerList.get(j);
                }
                outer[i] = inner;
            }
            return outer;
        }
    }

    public static void main(String[] args) {
        int x = new P2812().new Solution().maximumSafenessFactor(Arrs.build2DL("[[0,1,1],[0,1,1],[1,1,1]]"));
        System.out.println(x);
    }


}

package redo.p2800_2899;

public class P2850 {

    class Solution {
        public int minimumMoves(int[][] grid) {
//            int n = grid.length;
//            LinkedList<Node> queue = new LinkedList<>();
//            int[] dir = new int[]{0, 1, 0, -1, 0};
//            for (int i = 0; i < n; ++i) {
//                for (int j = 0; j < n; ++j) {
//                    if (grid[i][j] == 0) {
//                        queue.offer(new Node(i, j, 0));
//                    }
//                }
//            }
//            int ans = 0;
//            int num = queue.size();
//            while (num > 0) {
//                Node node = queue.poll();
//                if (grid[node.sx][node.sy] > 1) {
//                    --grid[node.sx][node.sy];
//                }
//            }
            return 1;
        }

        class Node {
            int sx, sy, dis;

            public Node(int sx, int sy, int dis) {
                this.sx = sx;
                this.sy = sy;
                this.dis = dis;
            }
        }
    }

}

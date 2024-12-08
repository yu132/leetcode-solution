package redo.p2800_2899;

import redo.testUtil.Arrs;

import java.util.ArrayList;
import java.util.List;

public class P2850 {

    class Solution {
        public int minimumMoves(int[][] grid) {
            List<Node> out = new ArrayList<>();
            List<Node> in = new ArrayList<>();
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    if (grid[i][j] > 1) {
                        out.add(new Node(i, j));
                    } else if (grid[i][j] == 0) {
                        in.add(new Node(i, j));
                    }
                }
            }
            return backtrack(out, in, grid);
        }

        int backtrack(List<Node> out, List<Node> in, int[][] grid) {
            if (in.isEmpty()) {
                return 0;
            }
            Node inNode = in.remove(in.size() - 1);
            int min = Integer.MAX_VALUE;
            for (Node node : out) {
                int dis = manhattanDistance(inNode.sx, inNode.sy, node.sx, node.sy);
                --grid[node.sx][node.sy];
                if (grid[node.sx][node.sy] == 1) {
                    List<Node> copy = new ArrayList<>(out);
                    copy.remove(node);
                    dis += backtrack(copy, in, grid);
                } else {
                    dis += backtrack(out, in, grid);
                }
                min = Math.min(min, dis);
                ++grid[node.sx][node.sy];
            }
            in.add(inNode);
            return min;
        }

        public int manhattanDistance(int x1, int y1, int x2, int y2) {
            return Math.abs(x2 - x1) + Math.abs(y2 - y1);
        }

        class Node {
            int sx, sy;

            public Node(int sx, int sy) {
                this.sx = sx;
                this.sy = sy;
            }
        }
    }

    public static void main(String[] args) {
        new P2850().new Solution().minimumMoves(Arrs.build2D("[[1,3,0],[1,0,0],[1,0,3]]"));
    }

}

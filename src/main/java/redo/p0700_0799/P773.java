package redo.p0700_0799;

import java.util.HashSet;
import java.util.LinkedList;

public class P773 {

    class Solution {

        int[][] dir = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        public int slidingPuzzle(int[][] board) {

            int nx = 0, ny = 0;

            for (int i = 0; i < 2; ++i) {
                for (int j = 0; j < 3; ++j) {
                    if (board[i][j] == 0) {
                        nx = i;
                        ny = j;
                        break;
                    }
                }
            }

            HashSet<Integer> visited = new HashSet<>();

            LinkedList<Node> queue = new LinkedList<>();
            queue.offer(new Node(nx, ny, board, 0));

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                int code = toVal(node.board);
                if (visited.contains(code)) {
                    continue;
                }
                visited.add(code);
                if (isTarget(node.board)) {
                    return node.depth;
                }
                for (int i = 0; i < 4; ++i) {
                    int xx = node.x0 + dir[i][0];
                    int yy = node.y0 + dir[i][1];

                    if (xx < 0 || xx == 2 || yy < 0 || yy == 3) {
                        continue;
                    }
                    int[][] newBoard = deepCopy(node.board);
                    newBoard[node.x0][node.y0] = newBoard[xx][yy];
                    newBoard[xx][yy] = 0;
                    queue.offer(new Node(xx, yy, newBoard, node.depth + 1));
                }
            }
            return -1;
        }

        int[][] deepCopy(int[][] arr) {
            int[][] copy = new int[2][3];
            for (int i = 0; i < 2; ++i) {
                for (int j = 0; j < 3; ++j) {
                    copy[i][j] = arr[i][j];
                }
            }
            return copy;
        }


        class Node {
            int x0, y0;
            int[][] board;
            int depth;

            public Node(int x0, int y0, int[][] board, int depth) {
                this.x0 = x0;
                this.y0 = y0;
                this.board = board;
                this.depth = depth;
            }
        }

        boolean isTarget(int[][] board) {
            for (int i = 0; i < 6; ++i) {
                if (board[i / 3][i % 3] != (i + 1) % 6) {
                    return false;
                }
            }
            return true;
        }

        int toVal(int[][] board) {
            int val = 0;
            for (int i = 0; i < 6; ++i) {
                val = val * 10 + board[i / 3][i % 3];
            }
            return val;
        }
    }

}

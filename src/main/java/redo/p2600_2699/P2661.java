package redo.p2600_2699;

import java.util.HashMap;
import java.util.Map;

public class P2661 {

    class Solution {
        public int firstCompleteIndex(int[] arr, int[][] mat) {
            int m = mat.length, n = mat[0].length;
            Map<Integer, Node> map = new HashMap<>();
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    map.put(mat[i][j], new Node(i, j));
                }
            }
            int[] countX = new int[m], countY = new int[n];
            for (int i = 0; i < arr.length; ++i) {
                Node node = map.get(arr[i]);
                ++countX[node.x];
                ++countY[node.y];
                if (countX[node.x] == n || countY[node.y] == m) {
                    return i;
                }
            }
            return -1;
        }

        class Node {
            int x, y;

            public Node(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

    }

}

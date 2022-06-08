package _0200_0299;

import java.util.LinkedList;

/**  
 * @ClassName: _286  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月10日  
 *  
 */
public class _286 {

    class Solution {

        class Node {
            int x;
            int y;
            int distince;

            public Node(int x, int y, int distince) {
                super();
                this.x        = x;
                this.y        = y;
                this.distince = distince;
            }
        }

        public void wallsAndGates(int[][] rooms) {

            LinkedList<Node> queue = new LinkedList<>();

            for (int i = 0; i < rooms.length; ++i) {
                for (int j = 0; j < rooms[0].length; ++j) {
                    if (rooms[i][j] == 0) {
                        queue.addLast(new Node(i, j, 0));
                    }
                }
            }

            while (!queue.isEmpty()) {
                Node node = queue.removeFirst();
                if (node.x < 0 || node.x >= rooms.length || node.y < 0 || node.y >= rooms[0].length) {
                    continue;
                }
                if (rooms[node.x][node.y] == -1 || rooms[node.x][node.y] < node.distince) {
                    continue;
                }

                rooms[node.x][node.y] = node.distince;

                queue.addLast(new Node(node.x + 1, node.y, node.distince + 1));
                queue.addLast(new Node(node.x - 1, node.y, node.distince + 1));
                queue.addLast(new Node(node.x, node.y + 1, node.distince + 1));
                queue.addLast(new Node(node.x, node.y - 1, node.distince + 1));
            }
        }
    }

}

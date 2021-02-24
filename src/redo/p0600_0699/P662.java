package redo.p0600_0699;

import java.util.Deque;
import java.util.LinkedList;

import model.TreeNode;

/**  
 * @ClassName: P662  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月23日  
 *  
 */
public class P662 {

    static//

    class Solution {
        public int widthOfBinaryTree(TreeNode root) {

            if (root == null) {
                return 0;
            }

            int max = 1;
            int level = -1, start = 0;

            Deque<Data> queue = new LinkedList<>();

            queue.offer(new Data(root, 1, 0));

            while (!queue.isEmpty()) {
                Data d = queue.poll();
                if (level != d.level) {
                    level = d.level;
                    start = d.index;
                }
                max = Math.max(max, d.index - start + 1);
                if (d.node.left != null) {
                    queue
                        .offer(new Data(d.node.left, d.index * 2, d.level + 1));
                }
                if (d.node.right != null) {
                    queue.offer(
                        new Data(d.node.right, d.index * 2 + 1, d.level + 1));
                }
            }

            return max;
        }

        static class Data {
            TreeNode node;
            int index;
            int level;

            public Data(TreeNode node, int index, int level) {
                super();
                this.node = node;
                this.index = index;
                this.level = level;
            }
        }
    }

}

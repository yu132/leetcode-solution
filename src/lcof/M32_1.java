package lcof;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import model.TreeNode;

/**  
 * @ClassName: M32_1  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月18日  
 *  
 */
public class M32_1 {

    class Solution {
        public int[] levelOrder(TreeNode root) {

            if (root == null) {
                return new int[0];
            }

            Deque<TreeNode> queue = new LinkedList<>();

            queue.addLast(root);

            List<Integer> list = new ArrayList<>();

            while (!queue.isEmpty()) {
                TreeNode node = queue.removeFirst();
                list.add(node.val);
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }

            int[] arr = new int[list.size()];

            for (int i = 0; i < arr.length; ++i) {
                arr[i] = list.get(i);
            }

            return arr;
        }
    }

}

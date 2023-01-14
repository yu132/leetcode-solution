package old._1300_1399;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.TreeNode;

/**  
 * @ClassName: _1305  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月17日  
 *  
 */
public class _1305 {

    class Solution {
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

            LinkedList<TreeNode> stack1 = new LinkedList<>();
            LinkedList<TreeNode> stack2 = new LinkedList<>();

            while (root1 != null) {
                stack1.addFirst(root1);
                root1 = root1.left;
            }

            while (root2 != null) {
                stack2.addFirst(root2);
                root2 = root2.left;
            }

            List<Integer> ans = new ArrayList<>();

            while (!stack1.isEmpty() && !stack2.isEmpty()) {
                TreeNode node;
                if (stack1.getFirst().val < stack2.getFirst().val) {
                    node = stack1.removeFirst();
                    ans.add(node.val);
                    if (node.right != null) {
                        node = node.right;
                        while (node != null) {
                            stack1.addFirst(node);
                            node = node.left;
                        }
                    }
                } else {
                    node = stack2.removeFirst();
                    ans.add(node.val);
                    if (node.right != null) {
                        node = node.right;
                        while (node != null) {
                            stack2.addFirst(node);
                            node = node.left;
                        }
                    }
                }
            }

            while (!stack1.isEmpty()) {
                TreeNode node = stack1.removeFirst();
                ans.add(node.val);
                if (node.right != null) {
                    node = node.right;
                    while (node != null) {
                        stack1.addFirst(node);
                        node = node.left;
                    }
                }
            }

            while (!stack2.isEmpty()) {
                TreeNode node = stack2.removeFirst();
                ans.add(node.val);
                if (node.right != null) {
                    node = node.right;
                    while (node != null) {
                        stack2.addFirst(node);
                        node = node.left;
                    }
                }
            }

            return ans;
        }
    }

}

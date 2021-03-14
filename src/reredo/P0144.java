package reredo;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;

/**  
 * @ClassName: P0144  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月4日  
 *  
 */
public class P0144 {

    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {

            List<Integer> ans = new ArrayList<>();

            while (root != null) {

                if (root.left == null) {
                    ans.add(root.val);
                    root = root.right;
                } else {

                    TreeNode maxLeft = findMaxLeft(root);

                    if (maxLeft.right == root) {
                        maxLeft.right = null;
                        root = root.right;
                    } else {
                        ans.add(root.val);
                        maxLeft.right = root;
                        root = root.left;
                    }
                }
            }

            return ans;
        }

        TreeNode findMaxLeft(TreeNode node) {
            TreeNode left = node.left;

            while (left.right != null && left.right != node) {
                left = left.right;
            }

            return left;
        }
    }

}

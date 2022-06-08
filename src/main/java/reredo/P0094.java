package reredo;

import java.util.ArrayList;
import java.util.List;

import model.ListNode;
import model.TreeNode;

/**  
 * @ClassName: P0094  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月4日  
 *  
 */
public class P0094 {

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {

            List<Integer> ans = new ArrayList<>();

            while (root != null) {

                if (root.left == null) {
                    ans.add(root.val);
                    root = root.right;
                } else {
                    TreeNode leftMax = findLeftMax(root);

                    if (leftMax.right == null) {
                        leftMax.right = root;
                        root = root.left;
                    } else {
                        ans.add(root.val);
                        leftMax.right = null;
                        root = root.right;
                    }
                }
            }

            return ans;
        }

        TreeNode findLeftMax(TreeNode node) {
            TreeNode left = node.left;
            while (left.right != null && left.right != node) {
                left = left.right;
            }
            return left;
        }
    }

}

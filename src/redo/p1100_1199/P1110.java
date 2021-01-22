package redo.p1100_1199;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;

/**  
 * @ClassName: P1110  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月15日  
 *  
 */
public class P1110 {

    class Solution {
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            boolean[] toDelete = new boolean[1001];
            for (int num : to_delete) {
                toDelete[num] = true;
            }
            List<TreeNode> ans = new ArrayList<>();
            root = helper(root, toDelete, ans);
            if (root != null) {
                ans.add(root);
            }
            return ans;
        }

        public TreeNode helper(TreeNode node, boolean[] toDelete, List<TreeNode> heads) {
            if (node == null) {
                return null;
            }
            if (toDelete[node.val]) {
                if (helper(node.left, toDelete, heads) != null) {
                    heads.add(node.left);
                }
                if (helper(node.right, toDelete, heads) != null) {
                    heads.add(node.right);
                }
                return null;
            }
            node.left = helper(node.left, toDelete, heads);
            node.right = helper(node.right, toDelete, heads);
            return node;
        }
    }

}

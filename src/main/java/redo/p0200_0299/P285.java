package redo.p0200_0299;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P285 {

    class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if (p.right != null) {
                return minRight(p);
            }
            List<TreeNode> ancestors = ancestorsOf(p, root);
            if (ancestors.isEmpty()) {
                return null;
            }
            ancestors.add(p);
            for (int i = ancestors.size() - 1; i >= 1; --i) {
                if (ancestors.get(i) == ancestors.get(i - 1).left) {
                    return ancestors.get(i - 1);
                }
            }
            return null;
        }

        TreeNode minRight(TreeNode node) {
            TreeNode n = node.right;
            if (n == null) {
                return null;
            }
            while (n.left != null) {
                n = n.left;
            }
            return n;
        }

        List<TreeNode> ancestorsOf(TreeNode node, TreeNode root) {
            List<TreeNode> ans = new ArrayList<>();
            ancestorsOfHelper(node, root, ans);
            return ans;
        }

        boolean ancestorsOfHelper(TreeNode target, TreeNode now, List<TreeNode> ans) {
            if (now == null) {
                return false;
            }
            if (now == target) {
                return true;
            }
            ans.add(now);
            if (ancestorsOfHelper(target, now.left, ans)) {
                return true;
            }
            if (ancestorsOfHelper(target, now.right, ans)) {
                return true;
            }
            ans.remove(ans.size() - 1);
            return false;
        }
    }

}

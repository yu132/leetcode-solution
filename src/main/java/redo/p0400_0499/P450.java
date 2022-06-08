package redo.p0400_0499;

import model.TreeNode;

/*
 * @ClassName: P450
 *
 * @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author 余定邦
 *
 * @date 2021年3月18日
 * 
 */
public class P450 {

    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            if (root.val < key) {
                root.right = deleteNode(root.right, key);
            } else if (root.val > key) {
                root.left = deleteNode(root.left, key);
            } else {
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                } else {
                    TreeNode minLeft = removeMinLeft(root);
                    root.val = minLeft.val;
                }
            }
            return root;
        }

        TreeNode removeMinLeft(TreeNode node) {
            if (node.left.right == null) {
                TreeNode ret = node.left;
                node.left = node.left.left;
                return ret;
            }
            TreeNode left = node.left;
            while (left.right != null) {
                node = left;
                left = left.right;
            }
            node.right = left.left;
            return left;
        }
    }

}

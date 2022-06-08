package redo.LCP;

import model.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class LCP44 {

    class Solution {
        public int numColor(TreeNode root) {

            Set<Integer> set = new HashSet<>();

            inorder(root, set::add);

            return set.size();
        }

        public void inorder(TreeNode node, Consumer<Integer> visiter) {
            if (node == null) {
                return;
            }
            inorder(node.left, visiter);
            visiter.accept(node.val);
            inorder(node.right, visiter);
        }
    }

}

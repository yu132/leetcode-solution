package redo.p2600_2699;

import model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class P2641 {

    class Solution {
        public TreeNode replaceValueInTree(TreeNode root) {
            List<Integer> sumLevel = new ArrayList<>();
            HashMap<TreeNode, Integer> countSelfAndBrother = new HashMap<>();

            LinkedList<Node> queue = new LinkedList<>();
            queue.offer(new Node(root, 0));
            countSelfAndBrother.put(root, root.val);

            while (!queue.isEmpty()) {
                Node node = queue.poll();

                if (node.level == sumLevel.size()) {
                    sumLevel.add(0);
                }
                sumLevel.set(node.level, sumLevel.get(node.level) + node.node.val);

                int left = node.node.left == null ? 0 : node.node.left.val;
                int right = node.node.right == null ? 0 : node.node.right.val;
                if (node.node.left != null) {
                    countSelfAndBrother.put(node.node.left, left + right);
                    queue.offer(new Node(node.node.left, node.level + 1));
                }
                if (node.node.right != null) {
                    countSelfAndBrother.put(node.node.right, left + right);
                    queue.offer(new Node(node.node.right, node.level + 1));
                }
            }

            TreeNode ansNodeRoot = new TreeNode(0);
            dfs(ansNodeRoot, root, sumLevel, countSelfAndBrother, 0);
            return ansNodeRoot;
        }

        void dfs(TreeNode ansNodeRoot, TreeNode root, List<Integer> sumLevel, HashMap<TreeNode, Integer> countSelfAndBrother, int level) {
            if (root.left != null) {
                ansNodeRoot.left = new TreeNode(sumLevel.get(level + 1) - countSelfAndBrother.get(root.left));
                dfs(ansNodeRoot.left, root.left, sumLevel, countSelfAndBrother, level + 1);
            }
            if (root.right != null) {
                ansNodeRoot.right = new TreeNode(sumLevel.get(level + 1) - countSelfAndBrother.get(root.right));
                dfs(ansNodeRoot.right, root.right, sumLevel, countSelfAndBrother, level + 1);
            }
        }

        class Node {
            TreeNode node;
            int level;

            public Node(TreeNode node, int level) {
                this.node = node;
                this.level = level;
            }
        }
    }

}

package redo.p2400_2499;

import model.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P2415 {

    class Solution {
        public TreeNode reverseOddLevels(TreeNode root) {
            Deque<Node> queue = new LinkedList<>();
            queue.offer(new Node(root, 0));
            List<Integer> l1 = new ArrayList<>();
            List<TreeNode> l2 = new ArrayList<>();
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                if (node.level % 2 == 1) {
                    l1.add(node.node.val);
                    l2.add(node.node);
                } else if (!l1.isEmpty()) {
                    for (int i = 0; i < l1.size(); ++i) {
                        l2.get(i).val = l1.get(l1.size() - i - 1);
                    }
                    l1.clear();
                    l2.clear();
                }
                if (node.node.left != null) {
                    queue.offer(new Node(node.node.left, node.level + 1));
                    queue.offer(new Node(node.node.right, node.level + 1));
                }
            }
            if (!l1.isEmpty()) {
                for (int i = 0; i < l1.size(); ++i) {
                    l2.get(i).val = l1.get(l1.size() - i - 1);
                }
            }
            return root;
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

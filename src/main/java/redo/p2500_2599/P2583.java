package redo.p2500_2599;

import model.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class P2583 {

    class Solution {
        public long kthLargestLevelSum(TreeNode root, int k) {
            List<Long> list = new ArrayList<>();
            LinkedList<Node> queue = new LinkedList<>();
            queue.offer(new Node(root, 0));
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                if (list.size() == node.level) {
                    list.add((long) node.node.val);
                } else {
                    list.set(node.level, list.get(node.level) + node.node.val);
                }
                if (null != node.node.left) {
                    queue.offer(new Node(node.node.left, node.level + 1));
                }
                if (null != node.node.right) {
                    queue.offer(new Node(node.node.right, node.level + 1));
                }
            }
            Collections.sort(list);
            if (k > list.size()) {
                return -1;
            } else {
                return list.get(list.size() - k);
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

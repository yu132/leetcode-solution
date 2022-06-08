package redo.p2000_2099;

import java.util.HashMap;
import java.util.Map;

public class P2049 {

    class Solution {

        long max = 0;
        int count = 0;

        public int countHighestScoreNodes(int[] parents) {
            PTreeNode head = toNormalBinaryTree(parents);
            countLeftAndRight(head);
            handleParentCount(head);
            dfs(head);
            return count;
        }

        void dfs(PTreeNode node) {
            if (node == null) {
                return;
            }
            long self = Math.max(1, node.parentCount) * Math.max(1, node.leftCount) * Math.max(1, node.rightCount);
            if (self > max) {
                max = self;
                count = 1;
            } else if (self == max) {
                ++count;
            }
            dfs(node.left);
            dfs(node.right);
        }

        void handleParentCount(PTreeNode node) {
            if (node == null) {
                return;
            }
            if (node.parent == null) {
                node.parentCount = 0;
            } else {
                if (node == node.parent.left) {
                    node.parentCount = node.parent.parentCount + node.parent.rightCount + 1;
                } else {
                    node.parentCount = node.parent.parentCount + node.parent.leftCount + 1;
                }
            }
            handleParentCount(node.left);
            handleParentCount(node.right);
        }

        long countLeftAndRight(PTreeNode node) {
            if (node == null) {
                return 0;
            }
            node.leftCount = countLeftAndRight(node.left);
            node.rightCount = countLeftAndRight(node.right);
            return node.leftCount + node.rightCount + 1;
        }

        PTreeNode toNormalBinaryTree(int[] parents) {
            Map<Integer, PTreeNode> maps = new HashMap<>();
            PTreeNode head = null;
            for (int i = 0; i < parents.length; ++i) {
                PTreeNode node = maps.computeIfAbsent(i, PTreeNode::new);
                maps.put(i, node);
                if (parents[i] == -1) {
                    head = node;
                    continue;
                }
                PTreeNode parent = maps.computeIfAbsent(parents[i], PTreeNode::new);
                node.parent = parent;
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }
            return head;
        }

        public class PTreeNode {
            public int val;
            public PTreeNode left;
            public PTreeNode right;
            public PTreeNode parent;

            public long leftCount, rightCount, parentCount;

            public PTreeNode(int x) {
                val = x;
            }
        }
    }

    public static void main(String[] args) {
        int val = new P2049().new Solution().countHighestScoreNodes(new int[]{-1, 2, 0, 2, 0});
        System.out.println(val);
    }

}

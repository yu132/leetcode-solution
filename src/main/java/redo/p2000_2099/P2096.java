package redo.p2000_2099;

import model.TreeNode;

public class P2096 {

    class Solution {
        public String getDirections(TreeNode root, int startValue, int destValue) {
            Node node = helper(root, startValue, destValue, true);
            return node.ans.toString();
        }

        Node helper(TreeNode node, int startValue, int destValue, boolean isLeft) {
            if (node == null) {
                return new Node(false, false, null);
            }
            Node self = new Node(node.val == startValue, node.val == destValue, new StringBuilder());
            Node left = helper(node.left, startValue, destValue, true),
                    right = helper(node.right, startValue, destValue, false);
            if (left.findStart && left.findDest) {
                return left;
            }
            if (right.findStart && right.findDest) {
                return right;
            }
            StringBuilder start = null, dest = null;
            if (self.findStart) {
                start = self.ans;
            }
            if (left.findStart) {
                start = left.ans;
            }
            if (right.findStart) {
                start = right.ans;
            }
            if (self.findDest) {
                dest = self.ans;
            }
            if (left.findDest) {
                dest = left.ans;
            }
            if (right.findDest) {
                dest = right.ans;
            }
            if (start != null && dest != null) {
                return new Node(true, true, start.append(dest.reverse()));
            }
            if (start != null) {
                return new Node(true, false, start.append('U'));
            }
            if (dest != null) {
                return new Node(false, true, dest.append(isLeft ? 'L' : 'R'));
            }
            return new Node(false, false, null);
        }

        class Node {
            boolean findStart, findDest;
            StringBuilder ans;

            public Node(boolean findStart, boolean findDest, StringBuilder ans) {
                this.findStart = findStart;
                this.findDest = findDest;
                this.ans = ans;
            }
        }

    }

}

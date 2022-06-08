package redo.p2200_2299;

import model.TreeNode;

public class P2236 {

    class Solution {
        public boolean checkTree(TreeNode root) {
            return root.val == root.left.val + root.right.val;
        }
    }

}

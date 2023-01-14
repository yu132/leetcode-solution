package redo.p1000_1099;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class P1028 {

    class Solution {
        public TreeNode recoverFromPreorder(String traversal) {
            Map<Integer, TreeNode> map = new HashMap<>();
            int count = 0;
            for (int i = 0; i < traversal.length(); ) {
                if (traversal.charAt(i) == '-') {
                    while (traversal.charAt(i) == '-') {
                        ++i;
                        ++count;
                    }
                } else {
                    int start = i;
                    while (i < traversal.length() && Character.isDigit(traversal.charAt(i))) {
                        ++i;
                    }
                    int num = Integer.parseInt(traversal.substring(start, i));
                    if (count == 0) {
                        map.put(0, new TreeNode(num));
                    } else {
                        TreeNode parent = map.get(count - 1);
                        TreeNode node = new TreeNode(num);
                        if (parent.left == null) {
                            parent.left = node;
                        } else {
                            parent.right = node;
                        }
                        map.put(count, node);
                    }
                    count = 0;
                }
            }
            return map.get(0);
        }
    }

}

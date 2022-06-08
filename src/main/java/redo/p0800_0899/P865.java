package redo.p0800_0899;

import java.util.HashMap;
import java.util.Map;

import model.TreeNode;

/**  
 * @ClassName: P865  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月15日  
 *  
 */
public class P865 {

    class Solution {
        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            return lcaDeepestLeaves(root);
        }

        public TreeNode lcaDeepestLeaves(TreeNode root) {
            Map<TreeNode, Integer> depth = new HashMap<>();
            depthEachNode(root, depth);
            while (true) {
                int left = depth.getOrDefault(root.left, 0), right = depth.getOrDefault(root.right, 0);
                if (left == right) {
                    return root;
                } else if (left > right) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
        }

        public int depthEachNode(TreeNode node, Map<TreeNode, Integer> map) {
            if (node == null) {
                return 0;
            }
            int depth = 1 + Math.max(depthEachNode(node.left, map), depthEachNode(node.right, map));
            map.put(node, depth);
            return depth;
        }
    }

}

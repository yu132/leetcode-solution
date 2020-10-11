package _1000_1099;

import java.util.HashMap;
import java.util.Map;

import model.TreeNode;

/**  
 * @ClassName: _1038  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月9日  
 *  
 */
public class _1038 {

    class Solution {
        public TreeNode bstToGst(TreeNode root) {
            Map<TreeNode, int[]> map = new HashMap<>();
            sum(map, root);
            helper(root, 0, map);
            return root;
        }

        public void helper(TreeNode root, int num, Map<TreeNode, int[]> map) {
            if (root == null) {
                return;
            }
            int[] count = map.get(root);
            helper(root.left, num + count[1] + root.val, map);
            helper(root.right, num, map);
            root.val = num + count[1] + root.val;
        }

        public int sum(Map<TreeNode, int[]> map, TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left  = sum(map, root.left);
            int right = sum(map, root.right);

            map.put(root, new int[] {left, right});

            return left + right + root.val;
        }
    }

}

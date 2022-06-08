package redo.p0300_0399;

import java.util.HashMap;
import java.util.Map;

import model.TreeNode;

/**  
 * @ClassName: P337  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月22日  
 *  
 */
public class P337 {

    class Solution {

        Map<TreeNode, Integer> rob = new HashMap<>(), notRob = new HashMap<>();

        public int rob(TreeNode root) {
            rob.put(null, 0);
            notRob.put(null, 0);
            dfs(root);
            return Math.max(rob.get(root), notRob.get(root));
        }

        public void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            dfs(root.right);
            int r = root.val + notRob.get(root.left) + notRob.get(root.right),
                nr = Math.max(rob.get(root.left), notRob.get(root.left))
                    + Math.max(rob.get(root.right), notRob.get(root.right));
            rob.put(root, r);
            notRob.put(root, nr);
        }
    }

}

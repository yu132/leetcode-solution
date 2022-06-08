package reredo;

import model.TreeNode;
import org.junit.platform.engine.support.hierarchical.Node;

/**  
 * @ClassName: P0098  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月5日  
 *  
 */
public class P0098 {

    class Solution {
        public boolean isValidBST(TreeNode root) {
            return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        boolean helper(TreeNode node, long min, long max) {

            if (node == null) {
                return true;
            }

            if (node.val <= min || node.val >= max) {
                return false;
            }

            return helper(node.left, min, node.val)
                && helper(node.right, node.val, max);
        }
    }

}

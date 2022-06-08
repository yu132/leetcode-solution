package redo.p0100_0199;

import model.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P14  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P114 {

    class Solution {

        TreeNode pre;

        public void flatten(TreeNode root) {
            preorder(root);
        }

        public void preorder(TreeNode node) {
            if (node == null) {
                return;
            }
            if (pre != null) {
                pre.right = node;
            }
            pre = node;
            TreeNode right = node.right;
            preorder(node.left);
            node.left = null;
            preorder(right);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
    }

}

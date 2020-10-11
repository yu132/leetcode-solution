/**
 * @Title: _998.java
 *
 * @Package _0900_0999
 *
 * @Description: TODO(用一句话描述该文件做什么)
 *
 * @author 余定邦
 *
 * @date 2020年1月31日
 *
 */
package _0900_0999;

import model.TreeNode;

/**  
 * @ClassName: _998  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年1月31日  
 *  
 */
public class _998 {

    class Solution {
        public TreeNode insertIntoMaxTree(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            } else if (val > root.val) {
                TreeNode node = new TreeNode(val);
                node.left = root;
                return node;
            } else {
                root.right = insertIntoMaxTree(root.right, val);
                return root;
            }
        }
    }

}

/**
 * @Title: _513.java
 *
 * @Package old._0500_0599
 *
 * @Description: TODO(用一句话描述该文件做什么)
 *
 * @author 余定邦
 *
 * @date 2020年1月30日
 *
 */
package old._0500_0599;

import java.util.ArrayDeque;
import java.util.Queue;

import model.TreeNode;

/**
 * @ClassName: _513
 *
 * @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author 余定邦
 *
 * @date 2020年1月30日
 * 
 */
public class _513 {

    class Solution {
        public int findBottomLeftValue(TreeNode root) {
            Queue<TreeNode> q = new ArrayDeque<>();
            q.offer(root);
            while (!q.isEmpty()) {
                root = q.poll();
                if (root.right != null) {
                    q.offer(root.right);
                }
                if (root.left != null) {
                    q.offer(root.left);
                }
            }
            return root.val;
        }
    }

}

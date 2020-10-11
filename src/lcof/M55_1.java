package lcof;

import model.TreeNode;

/**  
 * @ClassName: M55_1  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月22日  
 *  
 */
public class M55_1 {

    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }

}

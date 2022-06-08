package _0900_0999;

import model.TreeNode;

/**  
 * @ClassName: _968  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月22日  
 *  
 */
public class _968 {

    class Solution {

        int count = 0;

        public int minCameraCover(TreeNode root) {
            return dfs(root) == 0 ? count + 1 : count;
        }

        public int dfs(TreeNode root) {
            if (root == null) {
                return 1;
            }
            int left  = dfs(root.left);
            int right = dfs(root.right);

            if (left == 0 || right == 0) {
                ++count;
                return 2;
            } else if (left == 1 && right == 1) {
                return 0;
            } else if (left + right >= 3) {
                return 1;
            }
            return -1;
        }
    }

}

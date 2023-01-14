package old._0300_0399;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;

/**  
 * @ClassName: _366  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月12日  
 *  
 */
public class _366 {

    class Solution {
        public List<List<Integer>> findLeaves(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            helper(root, ans);
            return ans;
        }

        public int helper(TreeNode root, List<List<Integer>> list) {
            if (root == null) {
                return -1;
            }
            int deep = Math.max(helper(root.left, list), helper(root.right, list)) + 1;
            if (list.size() <= deep) {
                list.add(new ArrayList<>());
            }

            list.get(deep).add(root.val);

            return deep;
        }
    }

}

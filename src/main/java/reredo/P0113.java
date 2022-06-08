package reredo;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;

/**  
 * @ClassName: P0113  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月4日  
 *  
 */
public class P0113 {

    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> ans = new ArrayList<>();
            helper(root, 0, targetSum, new ArrayList<>(), ans);
            return ans;
        }

        void helper(TreeNode root, int sum, int targetSum, List<Integer> path,
            List<List<Integer>> ans) {

            if (root == null) {
                return;
            }

            path.add(root.val);

            sum += root.val;

            if (sum == targetSum && root.left == null && root.right == null) {
                ans.add(new ArrayList<>(path));
            }

            if (root.left != null) {
                helper(root.left, sum, targetSum, path, ans);
            }

            if (root.right != null) {
                helper(root.right, sum, targetSum, path, ans);
            }

            path.remove(path.size() - 1);
        }
    }

}

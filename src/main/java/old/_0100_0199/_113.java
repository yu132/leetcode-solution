package old._0100_0199;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.TreeNode;

/**  
 * @ClassName: _113  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月19日  
 *  
 */
public class _113 {

    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            if (root == null) {
                return Collections.emptyList();
            }
            List<List<Integer>> ans = new ArrayList<>();
            dfs(0, sum, root, ans, new ArrayList<>());
            return ans;
        }

        public void dfs(int now, int target, TreeNode root, List<List<Integer>> ans, List<Integer> nowNode) {
            now += root.val;
            nowNode.add(root.val);
            if (root.left == null && root.right == null) {
                if (now == target) {
                    ans.add(new ArrayList<>(nowNode));
                }
            } else {
                if (root.left != null) {
                    dfs(now, target, root.left, ans, nowNode);
                }
                if (root.right != null) {
                    dfs(now, target, root.right, ans, nowNode);
                }
            }
            nowNode.remove(nowNode.size() - 1);// 回溯
        }
    }

}

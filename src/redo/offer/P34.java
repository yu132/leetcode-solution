package redo.offer;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P34  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P34 {

    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> ans = new ArrayList<>();
            backtrack(root, new ArrayList<>(), ans, sum);
            return ans;
        }

        public void backtrack(TreeNode node, List<Integer> path,
            List<List<Integer>> ans, int sum) {
            if (node == null) {
                return;
            }

            path.add(node.val);

            if (sum == node.val && node.left == null && node.right == null) {
                ans.add(new ArrayList<>(path));
            }

            backtrack(node.left, path, ans, sum - node.val);
            backtrack(node.right, path, ans, sum - node.val);

            path.remove(path.size() - 1);
        }
    }


}

package _1100_1199;

import java.util.ArrayList;

import model.TreeNode;

/**  
 * @ClassName: _1161  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月6日  
 *  
 */
public class _1161 {

    class Solution {
        public int maxLevelSum(TreeNode root) {

            ArrayList<Integer> sum = new ArrayList<>();

            dfs(root, 0, sum);

            int maxValue = Integer.MIN_VALUE, max = 0;

            for (int i = 0; i < sum.size(); ++i) {
                if (sum.get(i) > maxValue) {
                    maxValue = sum.get(i);
                    max      = i + 1;
                }
            }

            return max;
        }

        public void dfs(TreeNode node, int level, ArrayList<Integer> sum) {
            if (node == null) {
                return;
            }
            if (sum.size() == level) {
                sum.add(0);
            }
            sum.set(level, sum.get(level) + node.val);
            dfs(node.left, level + 1, sum);
            dfs(node.right, level + 1, sum);
        }
    }

}

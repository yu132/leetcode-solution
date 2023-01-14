package old._1200_1299;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: _1273  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月15日  
 *  
 */
public class _1273 {

    class Solution {

        class TreeNode {
            int val;
            List<TreeNode> children;

            public TreeNode(int val) {
                super();
                this.val      = val;
                this.children = new ArrayList<>();
            }
        }

        public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
            TreeNode[] nodelist = new TreeNode[nodes];
            for (int i = 0; i < nodes; ++i) {
                nodelist[i] = new TreeNode(value[i]);
            }
            TreeNode root = null;
            for (int i = 0; i < nodes; ++i) {
                if (parent[i] == -1) {
                    root = nodelist[i];
                    continue;
                }
                nodelist[parent[i]].children.add(nodelist[i]);
            }
            return delete(root)[1];
        }

        public int[] delete(TreeNode node) {
            int sum       = node.val;
            int nodeCount = 1;
            for (int i = 0; i < node.children.size(); ++i) {
                int[] ans = delete(node.children.get(i));
                sum       += ans[0];
                nodeCount += ans[1];
            }
            return sum == 0 ? new int[] {0, 0} : new int[] {sum, nodeCount};
        }
    }

}

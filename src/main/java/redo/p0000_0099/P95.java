package redo.p0000_0099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.TreeNode;

/**  
 * @ClassName: P95  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月13日  
 *  
 */
public class P95 {

    class Solution {
        public List<TreeNode> generateTrees(int n) {
            return helper(1, n + 1);
        }

        List<TreeNode> helper(int low, int high) {
            if (low >= high) {
                return Arrays.asList((TreeNode)null);
            }
            List<TreeNode> ans = new ArrayList<>();
            for (int i = low; i < high; ++i) {
                List<TreeNode> left = helper(low, i),
                    right = helper(i + 1, high);
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode n = new TreeNode(i);
                        n.left = l;
                        n.right = r;
                        ans.add(n);
                    }
                }
            }
            return ans;
        }
    }


}

/**
 * @Title: _1110.java
 *
 * @Package _1100_1199
 *
 * @Description: TODO(用一句话描述该文件做什么)
 *
 * @author 余定邦
 *
 * @date 2020年2月10日
 *
 */
package _1100_1199;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.TreeNode;

/**  
 * @ClassName: _1110  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月10日  
 *  
 */
public class _1110 {

    class Solution {
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            if (root == null) {
                return Collections.emptyList();
            }
            Set<Integer> set = new HashSet<>();
            for (int each : to_delete) {
                set.add(each);
            }
            List<TreeNode> ans = new ArrayList<>();
            rootify(root, set, ans);
            return ans;
        }

        public void rootify(TreeNode node, Set<Integer> toDelete, List<TreeNode> list) {
            if (node == null) {
                return;
            }
            if (toDelete.contains(node.val)) {
                rootify(node.left, toDelete, list);
                rootify(node.right, toDelete, list);
            } else {
                list.add(node);
                nodify(node.left, toDelete, list, node, true);
                nodify(node.right, toDelete, list, node, false);
            }
        }

        public void nodify(TreeNode node, Set<Integer> toDelete, List<TreeNode> list, TreeNode father, boolean left) {
            if (node == null) {
                return;
            }
            if (toDelete.contains(node.val)) {
                if (left) {
                    father.left = null;
                } else {
                    father.right = null;
                }
                rootify(node.left, toDelete, list);
                rootify(node.right, toDelete, list);
            } else {
                nodify(node.left, toDelete, list, node, true);
                nodify(node.right, toDelete, list, node, false);
            }
        }
    }

}

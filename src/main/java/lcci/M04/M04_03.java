package lcci.M04;

import java.util.ArrayList;

import model.ListNode;
import model.TreeNode;

/**  
 * @ClassName: M04_03  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月29日  
 *  
 */
public class M04_03 {

    class Solution {
        public ListNode[] listOfDepth(TreeNode tree) {
            ArrayList<ListNode> ans = new ArrayList<>();
            helper(tree, 0, ans);
            return ans.toArray(new ListNode[ans.size()]);
        }

        public void helper(TreeNode tree, int deep, ArrayList<ListNode> ans) {
            if (tree == null) {
                return;
            }
            ListNode node = new ListNode(tree.val);
            if (ans.size() == deep) {
                ans.add(node);
            } else {
                ListNode next = ans.get(deep);
                node.next = next;
                ans.set(deep, node);
            }
            helper(tree.right, deep + 1, ans);
            helper(tree.left, deep + 1, ans);
        }
    }

}

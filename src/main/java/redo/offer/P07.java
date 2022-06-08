package redo.offer;

import java.util.Deque;
import java.util.LinkedList;

import model.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P07  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月2日  
 *  
 */
public class P07 {

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {

            if (preorder == null || preorder.length == 0) {
                return null;
            }

            int n = preorder.length;

            Deque<TreeNode> stack = new LinkedList<>();

            TreeNode root = new TreeNode(preorder[0]);

            stack.push(root);

            int inIndex = 0;

            for (int i = 1; i < n; ++i) {
                if (stack.peek().val != inorder[inIndex]) {
                    TreeNode node = new TreeNode(preorder[i]);
                    stack.peek().left = node;
                    stack.push(node);
                } else {
                    TreeNode parent = null;
                    while (!stack.isEmpty()
                        && stack.peek().val == inorder[inIndex]) {
                        ++inIndex;
                        parent = stack.pop();
                    }
                    parent.right = new TreeNode(preorder[i]);
                    stack.push(parent.right);
                }
            }

            return root;
        }
    }

    // class Solution {
    // public TreeNode buildTree(int[] preorder, int[] inorder) {
    // int n = preorder.length;
    // return helper(0, n, 0, n, preorder, inorder);
    // }
    //
    // public TreeNode helper(int lp, int hp, int li, int hi, int[] pre,
    // int[] in) {
    //
    // if (lp >= hp) {
    // return null;
    // }
    //
    // int rootVal = pre[lp];
    // int mi = -1;
    // for (int i = li; i < hi; ++i) {
    // if (in[i] == rootVal) {
    // mi = i;
    // break;
    // }
    // }
    // int len = mi - li;
    // int llp = lp + 1, lhp = lp + 1 + len, lli = li, lhi = mi;
    // int rlp = lhp, rhp = hp, rli = mi + 1, rhi = hi;
    //
    // TreeNode node = new TreeNode(rootVal);
    // node.left = helper(llp, lhp, lli, lhi, pre, in);
    // node.right = helper(rlp, rhp, rli, rhi, pre, in);
    // return node;
    // }
    // }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[3,9,20,null,null,15,7]", s
            .buildTree(new int[] {3, 9, 20, 15, 7}, new int[] {9, 3, 15, 20, 7})
            .toString());
    }

}

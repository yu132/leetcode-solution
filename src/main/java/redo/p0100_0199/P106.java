package redo.p0100_0199;

import model.TreeNode;

/**  
 * @ClassName: P106  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月13日  
 *  
 */
public class P106 {

    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            int n = inorder.length;
            return helper(inorder, postorder, 0, n, 0, n);
        }

        TreeNode helper(int[] inorder, int[] postorder, int iS, int iE, int pS,
            int pE) {
            if (iS >= iE) {
                return null;
            }
            int rootVal = postorder[pE - 1];

            int iM = -1;

            for (int i = iE - 1; i >= iS; --i) {
                if (inorder[i] == rootVal) {
                    iM = i;
                    break;
                }
            }

            int leftLen = iM - iS;

            TreeNode node = new TreeNode(rootVal);

            node.left = helper(inorder, postorder, iS, iM, pS, pS + leftLen);
            node.right =
                helper(inorder, postorder, iM + 1, iE, pS + leftLen, pE - 1);

            return node;
        }
    }

}

package redo2012_05_29start;

import model.TreeNode;

/**  
 * @ClassName: P0105  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年6月5日  
 *  
 */
public class P0105 {

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            return helper(preorder, inorder, 0, n, 0, n);
        }

        TreeNode helper(int[] preorder, int[] inorder, int pI, int pE, int iI,
            int iE) {
            if (pI >= pE) {
                return null;
            }
            int midValue = preorder[pI];
            int iM = iI;
            for (; iM < iE && inorder[iM] != midValue; ++iM);
            int lLen = iM - iI;

            TreeNode node = new TreeNode(midValue);
            node.left =
                helper(preorder, inorder, pI + 1, pI + 1 + lLen, iI, iM);
            node.right =
                helper(preorder, inorder, pI + 1 + lLen, pE, iM + 1, iE);
            return node;
        }
    }

}

package reredo;

import model.TreeNode;

/**  
 * @ClassName: P0105  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月2日  
 *  
 */
public class P0105 {

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            return helper(preorder, inorder, 0, n, 0, n);
        }

        TreeNode helper(int[] preorder, int[] inorder, int pS, int pE, int iS,
            int iE) {
            if (pS >= pE) {
                return null;
            }

            int rootVal = preorder[pS];
            int iM = iS;

            for (int i = iS; i < iE; ++i) {
                if (inorder[i] == rootVal) {
                    iM = i;
                    break;
                }
            }

            int leftLen = iM - iS;

            TreeNode root = new TreeNode(rootVal);

            root.left =
                helper(preorder, inorder, pS + 1, pS + 1 + leftLen, iS, iM);
            root.right =
                helper(preorder, inorder, pS + 1 + leftLen, pE, iM + 1, iE);

            return root;
        }
    }

}

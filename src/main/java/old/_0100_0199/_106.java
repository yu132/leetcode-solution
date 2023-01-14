/**
 * @Title: _106.java
 *
 * @Package old._0100_0199
 *
 * @Description: TODO(用一句话描述该文件做什么)
 *
 * @author 余定邦
 *
 * @date 2020年1月31日
 *
 */
package old._0100_0199;

import java.util.HashMap;

import model.TreeNode;

/**  
 * @ClassName: _106  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年1月31日  
 *  
 */
public class _106 {

    class Solution {

        private int index;

        private HashMap<Integer, Integer> st = new HashMap<>();

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            for (int i = 0; i < inorder.length; i++) {
                st.put(inorder[i], i);
            }
            index = postorder.length;
            return buildTree(inorder, 0, inorder.length, postorder);
        }

        public TreeNode buildTree(int[] inorder, int from, int to, int[] postorder) {
            if (from == to) {
                return null;
            }
            --index;

            int      i    = st.get(postorder[index]);
            TreeNode node = new TreeNode(inorder[i]);
            node.right = buildTree(inorder, i + 1, to, postorder);
            node.left  = buildTree(inorder, from, i, postorder);
            return node;
        }
    }

}

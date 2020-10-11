package _1000_1099;

import model.TreeNode;

/**  
 * @ClassName: _1008  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月4日  
 *  
 */
public class _1008 {

    class Solution {
        public TreeNode bstFromPreorder(int[] preorder) {
            return build(0, preorder.length, preorder);
        }

        public TreeNode build(int l, int h, int[] arr) {
            if (l >= h) {
                return null;
            }
            TreeNode node = new TreeNode(arr[l]);
            for (int i = l + 1; i < h; ++i) {
                if (arr[i] > arr[l]) {
                    node.left  = build(l + 1, i, arr);
                    node.right = build(i, h, arr);
                    return node;
                }
            }
            node.left  = build(l + 1, h, arr);
            node.right = null;
            return node;
        }
    }

}

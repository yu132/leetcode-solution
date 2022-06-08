package lcof;

import java.util.HashMap;
import java.util.Map;

import model.TreeNode;

/**  
 * @ClassName: M07  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月12日  
 *  
 */
public class M07 {

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inorder.length; ++i) {
                map.put(inorder[i], i);
            }
            return helper(preorder, map, 0, inorder.length, 0, inorder.length);
        }

        public TreeNode helper(int[] preorder, Map<Integer, Integer> inoderMap, int preIndex, int preTo, int inFrom,
            int inTo) {

            if (preIndex == preTo) {
                return null;
            }

            int      num         = preorder[preIndex];    // 前序遍历的值

            int      mid         = inoderMap.get(num);    // 在中序遍历中占的位置

            int      lenLeft     = mid - inFrom;          // 子树长度
            int      lenRight    = inTo - mid - 1;

            int      leftPre     = preIndex + 1;          // 子树在前序遍历中的位置
            int      rightPre    = preIndex + lenLeft + 1;

            int      leftPreTo   = leftPre + lenLeft;     // 子树在前序遍历中的末尾位置
            int      rightPreTo  = rightPre + lenRight;

            int      leftInFrom  = inFrom;                // 左子树在中序遍历的开始位置和末尾位置
            int      leftInTo    = mid;

            int      rightInFrom = mid + 1;               // 右子树在中序遍历的开始位置和末尾位置
            int      rightInTo   = inTo;

            TreeNode node        = new TreeNode(num);

            node.left  = helper(preorder, inoderMap, leftPre, leftPreTo, leftInFrom, leftInTo);
            node.right = helper(preorder, inoderMap, rightPre, rightPreTo, rightInFrom, rightInTo);

            return node;
        }
    }

    public static void main(String[] args) {
        new M07().new Solution().buildTree(new int[] {3, 9, 20, 15, 7}, new int[] {9, 3, 15, 20, 7});
    }

}

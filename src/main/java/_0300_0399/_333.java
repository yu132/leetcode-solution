package _0300_0399;

import model.TreeNode;
import utils.SerializeBT;

/**  
 * @ClassName: _333  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月11日  
 *  
 */
public class _333 {

    class Solution {
        public int largestBSTSubtree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return helper(root)[3];
        }

        public int[] helper(TreeNode node) {
            int     min      = node.val, max = node.val;
            boolean isBST    = true;
            int     leftSize = 0, rightSize = 0;
            if (node.left != null) {
                int[] left = helper(node.left);
                if (left[0] == -1 || node.val <= left[2]) {
                    isBST = false;
                } else {
                    min = left[1];
                }
                leftSize = left[3];
            }
            if (node.right != null) {
                int[] right = helper(node.right);
                if (right[0] == -1 || node.val >= right[1]) {
                    isBST = false;
                } else {
                    max = right[2];
                }
                rightSize = right[3];
            }
            return new int[] {isBST ? 1 : -1, min, max,
                isBST ? 1 + leftSize + rightSize : Math.max(leftSize, rightSize)};
        }
    }

    public static void main(String[] args) {
        // TreeNode _10=new TreeNode(10);
        // TreeNode _5=new TreeNode(5);
        // TreeNode _1=new TreeNode(1);
        // TreeNode _8=new TreeNode(8);
        //
        // TreeNode _15=new TreeNode(10);
        // TreeNode _7=new TreeNode(10);
        //
        // _10.left=_5;
        // _10.right=15;
        // _5.left=_1;

        SerializeBT s    = new SerializeBT();
        TreeNode    root = s.deserialize("[10,5,15,1,8,e,7]");
        new _333().new Solution().largestBSTSubtree(root);
    }
}

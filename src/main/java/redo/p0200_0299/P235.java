package redo.p0200_0299;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P235  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月18日  
 *  
 */
public class P235 {

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            if (p.val == root.val || q.val == root.val) {
                return root;
            } else if ((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val)) {
                return root;
            }
            if (p.val < root.val && q.val < root.val) {
                return lowestCommonAncestor(root.left, p, q);
            } else {// p.val > root.val && q.val > root.val
                return lowestCommonAncestor(root.right, p, q);
            }
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(6, s.lowestCommonAncestor(BinaryTreeTestUtil.build("[6,2,8,0,4,7,9,null,null,3,5]"),
            new TreeNode(2), new TreeNode(8)).val);

        assertEquals(2, s.lowestCommonAncestor(BinaryTreeTestUtil.build("[6,2,8,0,4,7,9,null,null,3,5]"),
            new TreeNode(2), new TreeNode(4)).val);
    }

}

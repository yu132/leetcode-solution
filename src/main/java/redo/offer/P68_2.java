package redo.offer;

import model.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P68_2  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P68_2 {

    class Solution {

        TreeNode ans;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,
            TreeNode q) {

            find(root, p, q);
            return ans;
        }

        public boolean find(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return false;
            }

            boolean l = find(root.left, p, q), r = find(root.right, p, q),
                pp = (root == p), qq = (root == q);
            if ((l && r) || ((l || r) && (pp || qq))) {
                ans = root;
                return false;
            }

            return l || r || pp || qq;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();

        TreeNode root =
            BinaryTreeTestUtil.build("[3,5,1,6,2,0,8,null,null,7,4]"),
            p = BinaryTreeTestUtil.find(root, 5),
            q = BinaryTreeTestUtil.find(root, 1),
            ans = BinaryTreeTestUtil.find(root, 3);

        Assert.assertEquals(ans, s.lowestCommonAncestor(root, p, q));
    }

}

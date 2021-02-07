package redo.offer;

import model.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P27  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P27 {

    class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode right = mirrorTree(root.left),
                left = mirrorTree(root.right);
            root.left = left;
            root.right = right;
            return root;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[4,7,2,9,6,3,1]",
            s.mirrorTree(BinaryTreeTestUtil.build("[4,2,7,1,3,6,9]"))
                .toString());
    }

}

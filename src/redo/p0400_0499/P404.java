package redo.p0400_0499;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P404  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P404 {

    class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            return sumLeft(root, false);
        }

        public int sumLeft(TreeNode node, boolean isLeft) {
            if (node == null) {
                return 0;
            }
            if (node.left == null && node.right == null && isLeft) {
                return node.val;
            }
            return sumLeft(node.left, true) + sumLeft(node.right, false);
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(24, s.sumOfLeftLeaves(BinaryTreeTestUtil.build("3,9,20,null,null,15,7")));
    }

}

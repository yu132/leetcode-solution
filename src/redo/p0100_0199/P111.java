package redo.p0100_0199;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P111  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月17日  
 *  
 */
public class P111 {

    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return depth(root, 1);
        }

        public int depth(TreeNode root, int depth) {
            if (root == null) {
                return Integer.MAX_VALUE;
            }
            if (root.left == null && root.right == null) {
                return depth;
            }
            return Math.min(depth(root.left, depth + 1), depth(root.right, depth + 1));
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();

        assertEquals(2, s.minDepth(BinaryTreeTestUtil.build("[3,9,20,null,null,15,7]")));
        assertEquals(1, s.minDepth(BinaryTreeTestUtil.build("[3]")));
        assertEquals(5, s.minDepth(BinaryTreeTestUtil.build("[2,null,3,null,4,null,5,null,6]")));
    }

}

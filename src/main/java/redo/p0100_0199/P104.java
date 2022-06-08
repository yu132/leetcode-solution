package redo.p0100_0199;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P104  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月17日  
 *  
 */
public class P104 {

    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();

        assertEquals(3, s.maxDepth(BinaryTreeTestUtil.build("[3,9,20,null,null,15,7]")));
    }

}

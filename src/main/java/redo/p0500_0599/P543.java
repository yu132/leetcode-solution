package redo.p0500_0599;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P543  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P543 {

    static//

    class Solution {
        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return helper(root).maxDiameter - 1;
        }

        public Data helper(TreeNode node) {
            if (node == null) {
                return NONE;
            }
            Data left = helper(node.left);
            Data right = helper(node.right);

            int maxD = Math.max(1 + left.maxHeight + right.maxHeight, Math.max(left.maxDiameter, right.maxDiameter));
            int maxH = 1 + Math.max(left.maxHeight, right.maxHeight);

            return new Data(maxD, maxH);
        }

        private final static Data NONE = new Data(0, 0);

        static class Data {
            int maxDiameter;
            int maxHeight;

            Data(int maxDiameter, int maxHeight) {
                super();
                this.maxDiameter = maxDiameter;
                this.maxHeight = maxHeight;
            }
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.diameterOfBinaryTree(BinaryTreeTestUtil.build("1,2,3,4,5")));
    }

}

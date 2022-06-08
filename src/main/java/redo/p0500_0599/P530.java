package redo.p0500_0599;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Consumer;

import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P530  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P530 {

    class Solution {
        public int getMinimumDifference(TreeNode root) {
            Data data = new Data();
            morrisInorder(root, (node) -> {
                if (!data.init) {
                    data.last = node.val;
                    data.init = true;
                } else {
                    data.min = Math.min(data.min, node.val - data.last);
                    data.last = node.val;
                }
            });
            return data.min;
        }

        class Data {
            int last;
            int min = Integer.MAX_VALUE;
            boolean init = false;
        }

        public void morrisInorder(TreeNode root, Consumer<TreeNode> visiter) {
            TreeNode current = root;
            while (current != null) {
                if (current.left == null) {
                    visiter.accept(current);
                    current = current.right;
                } else {

                    TreeNode maxLeftChild = current.left;
                    while (maxLeftChild.right != null && maxLeftChild.right != current) {
                        maxLeftChild = maxLeftChild.right;
                    }

                    if (maxLeftChild.right != current) {
                        maxLeftChild.right = current;
                        current = current.left;
                    }

                    else {
                        visiter.accept(current);
                        maxLeftChild.right = null;
                        current = current.right;
                    }
                }
            }
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.getMinimumDifference(BinaryTreeTestUtil.build("1,null,3,2")));
        assertEquals(47, s.getMinimumDifference(BinaryTreeTestUtil.build("[543,384,652,null,445,null,699]")));
    }

}

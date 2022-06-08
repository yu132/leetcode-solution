package redo.p0000_0099;

import java.util.Deque;
import java.util.LinkedList;

import model.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P99  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月25日  
 *  
 */
public class P99 {

    class Solution {
        public void recoverTree(TreeNode root) {
            morris(root);
        }

        TreeNode pred = null, x = null, y = null;

        void morris(TreeNode node) {

            while (node != null) {
                if (node.left == null) {
                    visited(node);
                    node = node.right;
                } else {
                    TreeNode maxLeft = findLeftMax(node);
                    if (maxLeft.right == node) {
                        visited(node);
                        maxLeft.right = null;
                        node = node.right;
                    } else {
                        maxLeft.right = node;
                        node = node.left;
                    }
                }
            }

            int temp = x.val;
            x.val = y.val;
            y.val = temp;

        }

        void visited(TreeNode node) {
            if (pred != null && pred.val > node.val) {
                if (x == null) {
                    x = pred;
                }
                y = node;
            }
            pred = node;
        }

        TreeNode findLeftMax(TreeNode node) {
            TreeNode n = node.left;
            while (n.right != null && n.right != node) {
                n = n.right;
            }
            return n;
        }
    }

    // class Solution {
    //
    // public void recoverTree(TreeNode root) {
    //
    // TreeNode pred = null, x = null, y = null;
    //
    // Deque<TreeNode> stack = new LinkedList<>();
    //
    // while (root != null) {
    // stack.push(root);
    // root = root.left;
    // }
    //
    // while (!stack.isEmpty()) {
    //
    // TreeNode node = stack.pop();
    //
    // if (pred != null && pred.val > node.val) {
    // if (x != null) {
    // x = pred;
    // }
    // y = node;
    // }
    //
    // pred = node;
    //
    // if (node.right != null) {
    // node = node.right;
    // while (node == null) {
    // stack.push(node);
    // node = node.left;
    // }
    // }
    // }
    //
    // int temp = x.val;
    // x.val = y.val;
    // y.val = temp;
    // }
    // }



    @Test
    public void test() {
        Solution s = new Solution();
        s.recoverTree(BinaryTreeTestUtil.build("[1,3,null,null,2]"));
    }

}

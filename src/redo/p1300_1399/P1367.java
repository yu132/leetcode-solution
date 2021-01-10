package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;

import model.ListNode;
import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;
import redo.testUtil.LinkedListTestUtil;

/**  
 * @ClassName: P1367  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月9日  
 *  
 */
public class P1367 {

    class Solution {
        public boolean isSubPath(ListNode head, TreeNode root) {
            if (helper(head, root)) {
                return true;
            }
            if (root == null) {
                return false;
            }
            return isSubPath(head, root.left) || isSubPath(head, root.right);
        }

        public boolean helper(ListNode head, TreeNode root) {
            if (head == null) {
                return true;
            } else if (root == null) {
                return false;
            }
            if (head.val == root.val) {
                return helper(head.next, root.left) || helper(head.next, root.right);
            }
            return false;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.isSubPath(LinkedListTestUtil.build("[4,2,8]"),
            BinaryTreeTestUtil.build("[1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]")));

        Assert.assertEquals(true, s.isSubPath(LinkedListTestUtil.build("[1,4,2,6]"),
            BinaryTreeTestUtil.build("[1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]")));

        Assert.assertEquals(false, s.isSubPath(LinkedListTestUtil.build("[1,4,2,6,8]"),
            BinaryTreeTestUtil.build("[1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]")));
    }

}

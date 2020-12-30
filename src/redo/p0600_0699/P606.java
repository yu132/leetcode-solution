package redo.p0600_0699;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P606  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P606 {

    class Solution {
        public String tree2str(TreeNode t) {
            if (t == null) {
                return "";
            }
            StringBuilder buf = new StringBuilder(100);
            helper(t, buf);
            return buf.toString();
        }

        public void helper(TreeNode node, StringBuilder buf) {
            buf.append(node.val);
            if (node.left != null) {
                buf.append('(');
                helper(node.left, buf);
                buf.append(')');
            } else {
                if (node.right != null) {
                    buf.append("()");
                }
            }

            if (node.right != null) {
                buf.append('(');
                helper(node.right, buf);
                buf.append(')');
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("1(2(4))(3)", s.tree2str(BinaryTreeTestUtil.build("[1,2,3,4]")));
        Assert.assertEquals("1(2()(4))(3)", s.tree2str(BinaryTreeTestUtil.build("[1,2,3,null,4]")));
    }

}

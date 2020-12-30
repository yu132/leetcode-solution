package redo.p0100_0199;

import static org.junit.Assert.*;
import static redo.testUtil.BinaryTreeTestUtil.*;

import org.junit.Test;

import model.TreeNode;

/**  
 * @ClassName: P100  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月17日  
 *  
 */
public class P100 {

    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if ((p == null && q != null) || (p != null && q == null)) {
                return false;
            }
            return p == q || p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();

        assertTrue(s.isSameTree(build("1,2,3"), build("1,2,3")));
        assertTrue(!s.isSameTree(build("1,2"), build("1,null,2")));
        assertTrue(!s.isSameTree(build("1,2,1"), build("1,1,2")));
    }

}

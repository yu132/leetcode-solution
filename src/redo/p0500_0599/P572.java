package redo.p0500_0599;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P572  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P572 {

    class Solution {

        private List<TreeNode> nodes = new ArrayList<>();
        private int tW = -1, tV = -1;

        public boolean isSubtree(TreeNode s, TreeNode t) {
            tW = weight(t);
            tV = t.val;
            weight(s);
            for (TreeNode node : nodes) {
                if (same(node, t)) {
                    return true;
                }
            }
            return false;
        }

        public boolean same(TreeNode p, TreeNode q) {
            if ((p == null && q != null) || (p != null && q == null)) {
                return false;
            }
            return p == q || p.val == q.val && same(p.left, q.left) && same(p.right, q.right);
        }

        private int weight(TreeNode s) {
            if (s == null) {
                return 0;
            }
            int weight = 1 + weight(s.left) + weight(s.right);
            if (weight == tW && s.val == tV) {
                nodes.add(s);
            }
            return weight;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true,
            s.isSubtree(BinaryTreeTestUtil.build("3,4,5,1,2"), BinaryTreeTestUtil.build("4,1,2")));

        s = new Solution();
        Assert.assertEquals(false, s.isSubtree(BinaryTreeTestUtil.build("3,4,5,1,2,null,null,null,null,0"),
            BinaryTreeTestUtil.build("4,1,2")));

    }
}

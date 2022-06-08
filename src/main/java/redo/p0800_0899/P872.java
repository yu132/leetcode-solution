package redo.p0800_0899;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P872  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月22日  
 *  
 */
public class P872 {

    class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            LeafIterator it1 = new LeafIterator(root1), it2 = new LeafIterator(root2);
            while (it1.hasNextLeaf() && it2.hasNextLeaf()) {
                if (it1.nextLeaf() != it2.nextLeaf()) {
                    return false;
                }
            }
            return !it1.hasNextLeaf() ^ it2.hasNextLeaf();
        }

        class LeafIterator {
            Deque<TreeNode> nodes;

            LeafIterator(TreeNode root) {
                super();
                this.nodes = new LinkedList<>();
                if (root != null) {
                    this.nodes.push(root);
                }
            }

            public int nextLeaf() {
                TreeNode node = nodes.pop();
                while (true) {
                    if (node.left == null && node.right == null) {
                        return node.val;
                    } else if (node.left != null) {
                        if (node.right != null) {
                            nodes.push(node.right);
                        }
                        node = node.left;
                    } else {
                        node = node.right;
                    }
                }
            }

            public boolean hasNextLeaf() {
                return !nodes.isEmpty();
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.leafSimilar(BinaryTreeTestUtil.build("[3,5,1,6,2,9,8,null,null,7,4]"),
            BinaryTreeTestUtil.build("[3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]")));
        Assert.assertEquals(true, s.leafSimilar(BinaryTreeTestUtil.build("[1]"), BinaryTreeTestUtil.build("[1]")));
        Assert.assertEquals(false, s.leafSimilar(BinaryTreeTestUtil.build("[1]"), BinaryTreeTestUtil.build("[2]")));
        Assert.assertEquals(true, s.leafSimilar(BinaryTreeTestUtil.build("[1,2]"), BinaryTreeTestUtil.build("[2,2]")));
        Assert.assertEquals(false,
            s.leafSimilar(BinaryTreeTestUtil.build("[1,2,3]"), BinaryTreeTestUtil.build("[1,3,2]")));
    }

}

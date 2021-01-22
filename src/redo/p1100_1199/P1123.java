package redo.p1100_1199;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P1123  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月15日  
 *  
 */
public class P1123 {

    class Solution {

        public TreeNode lcaDeepestLeaves(TreeNode root) {
            Map<TreeNode, Integer> depth = new HashMap<>();
            depthEachNode(root, depth);
            while (true) {
                int left = depth.getOrDefault(root.left, 0), right = depth.getOrDefault(root.right, 0);
                if (left == right) {
                    return root;
                } else if (left > right) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
        }

        public int depthEachNode(TreeNode node, Map<TreeNode, Integer> map) {
            if (node == null) {
                return 0;
            }
            int depth = 1 + Math.max(depthEachNode(node.left, map), depthEachNode(node.right, map));
            map.put(node, depth);
            return depth;
        }

    }



    @Test
    public void test() {
        Solution s = new Solution();
        // Assert.assertEquals(2, s.lcaDeepestLeaves(BinaryTreeTestUtil.build("[3,5,1,6,2,0,8,null,null,7,4]")).val);
        //
        // Assert.assertEquals(1, s.lcaDeepestLeaves(BinaryTreeTestUtil.build("[1]")).val);
        //
        // Assert.assertEquals(2, s.lcaDeepestLeaves(BinaryTreeTestUtil.build("[0,1,3,null,2]")).val);

        Assert.assertEquals(1,
            s.lcaDeepestLeaves(BinaryTreeTestUtil.build("[1,4,2,5,null,6,3,null,8,null,null,7]")).val);
    }

}

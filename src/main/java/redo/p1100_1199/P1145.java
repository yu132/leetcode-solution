package redo.p1100_1199;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P1145  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月14日  
 *  
 */
public class P1145 {

    class Solution {

        public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
            Map<TreeNode, Integer> countEachNode = new HashMap<>();
            countEachNode(root, countEachNode);
            TreeNode node = find(root, x);
            int a = countEachNode.get(root) - countEachNode.get(node), b = countEachNode.getOrDefault(node.left, 0),
                c = countEachNode.getOrDefault(node.right, 0);
            return a > b + c + 1 || b > a + c + a || c > a + b + 1;
        }

        public TreeNode find(TreeNode node, int x) {
            if (node == null) {
                return null;
            }
            if (node.val == x) {
                return node;
            }
            TreeNode left = find(node.left, x);
            if (left != null) {
                return left;
            }
            TreeNode right = find(node.right, x);
            if (right != null) {
                return right;
            }
            return null;
        }

        public int countEachNode(TreeNode node, Map<TreeNode, Integer> map) {
            if (node == null) {
                return 0;
            }
            int sum = 1 + countEachNode(node.left, map) + countEachNode(node.right, map);
            map.put(node, sum);
            return sum;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        // Assert.assertEquals(true, s.btreeGameWinningMove(BinaryTreeTestUtil.build("[1,2,3,4,5,6,7,8,9,10,11]"), 11,
        // 3));
        // Assert.assertEquals(false, s.btreeGameWinningMove(BinaryTreeTestUtil.build("[1,2,3]"), 3, 1));
        // Assert.assertEquals(true, s.btreeGameWinningMove(BinaryTreeTestUtil.build("[1,2,3,4,5]"), 5, 1));
        Assert.assertEquals(false, s.btreeGameWinningMove(BinaryTreeTestUtil.build("[5,null,4,2,null,3,1]"), 5, 2));
    }

}

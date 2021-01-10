package redo.p1300_1399;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P1339  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月10日  
 *  
 */
public class P1339 {

    static//

    class Solution {

        public final static int MOD = 1000000007;

        Map<TreeNode, Integer> sumTree;

        public int maxProduct(TreeNode root) {
            sumTree = new HashMap<>();
            sum(root);
            return (int)(helper(root, sumTree.get(root)) % MOD);
        }

        public long helper(TreeNode node, int root) {
            if (node == null) {
                return 0;
            }
            long sumSelf = sumTree.get(node), sumAllExceptSelf = root - sumSelf;
            long product = sumSelf * sumAllExceptSelf, left = helper(node.left, root), right = helper(node.right, root);
            return Math.max(Math.max(product, left), right);
        }

        public int sum(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int sum = node.val + sum(node.left) + sum(node.right);
            sumTree.put(node, sum);
            return sum;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(90, s.maxProduct(BinaryTreeTestUtil.build("[1,null,2,3,4,null,null,5,6]")));
        Assert.assertEquals(1025, s.maxProduct(BinaryTreeTestUtil.build("[2,3,9,10,7,8,6,5,4,11,1]")));
        Assert.assertEquals(1, s.maxProduct(BinaryTreeTestUtil.build("[1,1]")));
    }

}

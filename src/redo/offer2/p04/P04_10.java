package redo.offer2.p04;

import model.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P04_10  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月9日  
 *  
 */
public class P04_10 {

    class Solution {

        final static int PRIME = 29, MOD = Integer.MAX_VALUE;

        public boolean checkSubTree(TreeNode t1, TreeNode t2) {
            int ht2 = hash(t2);
            return helper(t1, t2, ht2) < 0;
        }

        public int helper(TreeNode t1, TreeNode t2, int ht2) {
            if (t1 == null) {
                return 0;
            }
            int left = helper(t1.left, t2, ht2);
            if (left < 0) {
                return left;
            }
            int right = helper(t1.right, t2, ht2);
            if (right < 0) {
                return right;
            }
            int ht1 = hash(left, right, t1.val);
            if (ht1 == ht2 && same(t1, t2)) {
                return -1;
            }
            return ht1;
        }

        public boolean same(TreeNode t1, TreeNode t2) {
            if (t1 == t2) {
                return true;
            }
            if (t1 == null || t2 == null) {
                return false;
            }
            return t1.val == t2.val && same(t1.left, t2.left)
                && same(t1.right, t2.right);
        }

        public int hash(TreeNode node) {
            if (node == null) {
                return 0;
            }
            return hash(hash(node.left), hash(node.right), node.val);
        }

        public int hash(long left, long right, int val) {
            return (int)(((left ^ right) * PRIME + val) % MOD);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        // Assert.assertEquals(true, s.checkSubTree(BinaryTreeTestUtil.build(
        // "[1,5,2,47,7,6,3,null,null,59,22,null,16,9,4,null,null,60,26,20,null,10,11,33,8,null,null,53,28,35,49,12,13,null,15,null,null,41,null,null,null,null,30,37,45,null,null,23,19,null,14,39,18,62,null,null,null,52,null,null,61,40,null,21,27,17,32,null,51,31,null,null,null,null,null,null,null,null,43,48,24,null,44,29,null,null,46,null,54,50,38,58,null,null,null,25,34,null,null,null,null,null,null,null,null,null,null,56,null,63,null,null,null,null,36,null,null,null,null,42,57,55,64]"),
        // BinaryTreeTestUtil.build("[33]")));

        Assert.assertEquals(true, s.checkSubTree(BinaryTreeTestUtil.build(
            "[358,361,359,373,367,360,364,null,380,368,383,362,379,null,366,381,null,385,374,null,406,363,null,391,null,372,369,null,null,405,404,393,397,null,null,375,365,null,392,403,377,376,371,null,408,null,null,null,410,null,null,null,null,370,401,null,null,null,null,388,null,null,395,384,382,null,null,null,411,409,378,null,null,null,null,null,402,389,null,396,null,null,null,null,null,null,386,413,null,null,null,null,null,394,387,null,null,412,399,400,390,null,null,null,null,null,null,null,398,null,407]"),
            BinaryTreeTestUtil.build(
                "[363,375,365,null,null,370,401,409,378,null,null,null,null,null,386,394,387,412,399,400,390,null,null,null,null,null,null,null,398,null,407]")));
    }
}

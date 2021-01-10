package redo.p1400_1499;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P1457  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月7日  
 *  
 */
public class P1457 {

    class Solution {
        public int pseudoPalindromicPaths(TreeNode root) {
            return helper(root, new int[10]);
        }

        public int helper(TreeNode node, int[] count) {
            if (node == null) {
                return 0;
            }
            ++count[node.val];
            if (node.left == null && node.right == null) {
                boolean temp = check(count);
                --count[node.val];
                return temp ? 1 : 0;
            }
            int ans = 0;
            ans += helper(node.left, count);
            ans += helper(node.right, count);
            --count[node.val];
            return ans;
        }

        boolean check(int[] count) {
            int odd = 0;
            for (int num : count) {
                if (num % 2 != 0) {
                    ++odd;
                }
            }
            return odd <= 1;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.pseudoPalindromicPaths(BinaryTreeTestUtil.build("[2,3,1,3,1,null,1]")));
        Assert.assertEquals(1,
            s.pseudoPalindromicPaths(BinaryTreeTestUtil.build("[2,1,1,1,3,null,null,null,null,null,1]")));
        Assert.assertEquals(1, s.pseudoPalindromicPaths(BinaryTreeTestUtil.build("[9]")));


    }

}

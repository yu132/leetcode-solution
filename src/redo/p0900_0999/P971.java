package redo.p0900_0999;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P971  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月21日  
 *  
 */
public class P971 {

    static//

    class Solution {

        final static List<Integer> FAILURE = Arrays.asList(-1);

        boolean success;
        int index;

        public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
            success = true;
            index = 0;
            List<Integer> ans = new ArrayList<>();
            helper(root, voyage, ans);
            if (!success) {
                return FAILURE;
            }
            return ans;
        }

        public void helper(TreeNode node, int[] voyage, List<Integer> ans) {

            if (!success) {
                return;
            }

            if (node.val != voyage[index]) {
                success = false;
                return;
            }

            ++index;

            if (node.left == null && node.right == null) {
                return;
            }

            if (node.left == null) {
                helper(node.right, voyage, ans);
            }

            else if (node.right == null) {
                helper(node.left, voyage, ans);
            }

            else if (node.left.val != voyage[index]) {
                ans.add(node.val);
                helper(node.right, voyage, ans);
                helper(node.left, voyage, ans);
            } else {
                helper(node.left, voyage, ans);
                helper(node.right, voyage, ans);
            }

        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        // Assert.assertEquals(Arrays.asList(-1), s.flipMatchVoyage(BinaryTreeTestUtil.build("[1,2]"), new int[] {2,
        // 1}));
        // Assert.assertEquals(Arrays.asList(1),
        // s.flipMatchVoyage(BinaryTreeTestUtil.build("[1,2,3]"), new int[] {1, 3, 2}));
        // Assert.assertEquals(Arrays.asList(),
        // s.flipMatchVoyage(BinaryTreeTestUtil.build("[1,2,3]"), new int[] {1, 2, 3}));
        //
        // Assert.assertEquals(Arrays.asList(),
        // s.flipMatchVoyage(BinaryTreeTestUtil.build("[1,null,2]"), new int[] {1, 2}));

        Assert.assertEquals(Arrays.asList(2),
            s.flipMatchVoyage(BinaryTreeTestUtil.build("[2,1,4,5,null,3]"), new int[] {2, 4, 3, 1, 5}));
    }
}

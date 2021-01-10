package redo.p1300_1399;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P1382  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月9日  
 *  
 */
public class P1382 {

    class Solution {
        public TreeNode balanceBST(TreeNode root) {
            List<Integer> nums = new ArrayList<>();
            inorder(root, (num) -> nums.add(num));
            return build(0, nums.size(), nums);
        }

        TreeNode build(int left, int right, List<Integer> nums) {
            if (left == right) {
                return null;
            }
            if (left == right - 1) {
                return new TreeNode(nums.get(left));
            }
            int mid = (left + right) >>> 1;
            TreeNode node = new TreeNode(nums.get(mid));
            node.left = build(left, mid, nums);
            node.right = build(mid + 1, right, nums);
            return node;
        }

        public void inorder(TreeNode node, Consumer<Integer> visiter) {
            if (node == null) {
                return;
            }
            inorder(node.left, visiter);
            visiter.accept(node.val);
            inorder(node.right, visiter);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[3,2,4,1]",
            BinaryTreeTestUtil.toStr(s.balanceBST(BinaryTreeTestUtil.build("[1,null,2,null,3,null,4,null,null]"))));
    }

}

package redo.p0100_0199;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P108  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月17日  
 *  
 */
public class P108 {

    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return helper(nums, 0, nums.length);
        }

        private TreeNode helper(int[] nums, int low, int high) {
            if (low == high) {
                return null;
            }
            int mid = (low + high) >>> 1;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = helper(nums, low, mid);
            node.right = helper(nums, mid + 1, high);
            return node;

        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("[0,-3,9,-10,null,5]", BinaryTreeTestUtil.toStr(s.sortedArrayToBST(new int[] {-10, -3, 0, 5, 9})));
    }

}

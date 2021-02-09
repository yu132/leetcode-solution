package redo.offer2.p04;

import model.TreeNode;

/**  
 * @ClassName: P04_02  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月9日  
 *  
 */
public class P04_02 {

    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return treeify(nums, 0, nums.length);
        }

        public TreeNode treeify(int[] nums, int start, int end) {
            if (start >= end) {
                return null;
            }
            int mid = (start + end) >>> 1;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = treeify(nums, start, mid);
            node.right = treeify(nums, mid + 1, end);
            return node;
        }
    }

}

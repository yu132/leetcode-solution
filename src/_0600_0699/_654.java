/**
 * @Title: _654.java
 *
 * @Package _0600_0699
 *
 * @Description: TODO(用一句话描述该文件做什么)
 *
 * @author 余定邦
 *
 * @date 2020年1月31日
 *
 */
package _0600_0699;

import model.TreeNode;

/**  
 * @ClassName: _654  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年1月31日  
 *  
 */
public class _654 {

    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return constructMaximumBinaryTree(nums, 0, nums.length);
        }

        public TreeNode constructMaximumBinaryTree(int[] nums, int from, int to) {
            if (from >= to) {
                return null;
            }
            int max = nums[from], index = from;
            for (int i = from + 1; i < to; ++i) {
                if (nums[i] > max) {
                    max   = nums[i];
                    index = i;
                }
            }

            TreeNode node = new TreeNode(max);
            node.left  = constructMaximumBinaryTree(nums, from, index);
            node.right = constructMaximumBinaryTree(nums, index + 1, to);
            return node;
        }

    }

}

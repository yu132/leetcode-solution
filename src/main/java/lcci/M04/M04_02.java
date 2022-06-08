package lcci.M04;

import model.TreeNode;

/**  
 * @ClassName: M04_02  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月29日  
 *  
 */
public class M04_02 {

    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return helper(nums, 0, nums.length);
        }

        public TreeNode helper(int[] nums, int from, int to) {
            if (from >= to) {
                return null;
            }
            int      mid  = (from + to) >>> 1;
            TreeNode node = new TreeNode(nums[mid]);
            node.left  = helper(nums, from, mid);
            node.right = helper(nums, mid + 1, to);
            return node;
        }
    }

}

package redo.p1000_1099;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;

/**  
 * @ClassName: P1008  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月20日  
 *  
 */
public class P1008 {

    class Solution {
        public TreeNode bstFromPreorder(int[] preorder) {
            return helper(preorder, 0, preorder.length);
        }

        public TreeNode helper(int[] preorder, int low, int high) {
            if (low >= high) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[low]);
            int mid = lowerBound(preorder, low + 1, high, preorder[low]);
            root.left = helper(preorder, low + 1, mid);
            root.right = helper(preorder, mid, high);
            return root;
        }

        private int lowerBound(int[] preorder, int low, int high, int target) {
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (preorder[mid] > target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[8,5,10,1,7,null,12]", s.bstFromPreorder(new int[] {8, 5, 1, 7, 10, 12}).toString());
    }

}

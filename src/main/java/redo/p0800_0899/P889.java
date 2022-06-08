package redo.p0800_0899;

import model.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P889  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月26日  
 *  
 */
public class P889 {

    class Solution {
        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            return helper(pre, post, 0, pre.length, 0, pre.length);
        }

        TreeNode helper(int[] pre, int[] post, int preLow, int preHigh, int postLow, int postHigh) {
            if (preLow >= preHigh) {
                return null;
            }
            TreeNode root = new TreeNode(pre[preLow]);
            if (preLow == preHigh - 1) {
                return root;
            }
            int leftChild = pre[preLow + 1], leftPost = -1;
            for (int i = postLow; i < postHigh; ++i) {
                if (leftChild == post[i]) {
                    leftPost = i;
                    break;
                }
            }
            int leftLen = leftPost - postLow + 1;
            root.left = helper(pre, post, preLow + 1, preLow + 1 + leftLen, postLow, postLow + leftLen);
            root.right = helper(pre, post, preLow + 1 + leftLen, preHigh, postLow + leftLen, postHigh - 1);
            return root;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[1,2,3,4,5,6,7]",
            s.constructFromPrePost(new int[] {1, 2, 4, 5, 3, 6, 7}, new int[] {4, 5, 2, 6, 7, 3, 1}).toString());
    }

}

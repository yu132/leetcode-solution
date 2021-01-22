package redo.p0600_0699;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;

/**  
 * @ClassName: P654  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月20日  
 *  
 */
public class P654 {

    static//

    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            int[][] rmq = rmqMaxIndexInit(nums);
            return helper(nums, 0, nums.length, rmq);
        }

        public TreeNode helper(int[] nums, int low, int high, int[][] rmq) {
            if (low >= high) {
                return null;
            }
            int maxIndex = queryMaxIndex(low, high - 1, rmq, nums);
            TreeNode node = new TreeNode(nums[maxIndex]);
            node.left = helper(nums, low, maxIndex, rmq);
            node.right = helper(nums, maxIndex + 1, high, rmq);
            return node;
        }

        static int[][] rmqMaxIndexInit(int[] arr) {
            int n = arr.length;
            int[][] dp = new int[n][(int)(Math.log(n + 1) / Math.log(2)) + 1];
            for (int i = 0; i < n; ++i) {
                dp[i][0] = i;
            }
            for (int j = 1; (1 << j) <= n; ++j) {
                for (int i = 0; i + (1 << j) - 1 < n; ++i) {
                    if (arr[dp[i][j - 1]] > arr[dp[i + (1 << (j - 1))][j - 1]]) {
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        dp[i][j] = dp[i + (1 << (j - 1))][j - 1];
                    }
                }
            }
            return dp;
        }

        // 区间为[start,end]，end是区间内的
        static int queryMaxIndex(int start, int end, int[][] dp, int[] arr) {
            int mid = (int)(Math.log(end - start + 1) / Math.log(2));
            if (arr[dp[start][mid]] > arr[dp[end - (1 << mid) + 1][mid]]) {
                return dp[start][mid];
            } else {
                return dp[end - (1 << mid) + 1][mid];
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[6,3,5,null,2,0,null,null,1]",
            s.constructMaximumBinaryTree(new int[] {3, 2, 1, 6, 0, 5}).toString());
        Assert.assertEquals("[3,null,2,null,1]", s.constructMaximumBinaryTree(new int[] {3, 2, 1}).toString());
    }

}

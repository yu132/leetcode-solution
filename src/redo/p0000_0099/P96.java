package redo.p0000_0099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.TreeNode;

/**  
 * @ClassName: P96  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月13日  
 *  
 */
public class P96 {

    class Solution {
        public int numTrees(int n) {
            dp = new int[n + 1];
            return helper(1, n + 1);
        }

        int[] dp;

        int helper(int low, int high) {
            if (low >= high) {
                return 1;
            }
            if (dp[high - low] == 0) {
                int sum = 0;
                for (int i = low; i < high; ++i) {
                    int left = helper(low, i), right = helper(i + 1, high);
                    sum += left * right;
                }
                dp[high - low] = sum;
            }
            return dp[high - low];
        }
    }

}

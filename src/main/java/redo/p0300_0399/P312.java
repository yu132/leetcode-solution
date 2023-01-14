package redo.p0300_0399;

public class P312 {

    class Solution {
        public int maxCoins(int[] nums) {
            int[] arr = new int[nums.length + 2];
            arr[0] = arr[arr.length - 1] = 1;
            System.arraycopy(nums, 0, arr, 1, nums.length);
            int n = nums.length;
            int[][] dp = new int[n + 5][n + 5];

            for (int l = 1; l <= n; ++l) {
                for (int i = 1; i <= n; ++i) {
                    int j = i + l - 1;
                    if (j > n) {
                        break;
                    }
                    if (i == j) {
                        dp[i][j] = arr[i - 1] * arr[i] * arr[i + 1];
                    } else {
                        for (int k = i; k <= j; ++k) {
                            dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j + 1]);
                        }
                    }
                }
            }

            return dp[1][n];
        }
    }

}

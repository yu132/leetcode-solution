package redo.p2000_2099;

public class P2012 {

    class Solution {
        public int sumOfBeauties(int[] nums) {

            int[] maxPre = maxFromStartToI(nums), minNext = minFromIToEnd(nums);

            int ans = 0;

            for (int i = 1; i < nums.length - 1; ++i) {
                if (maxPre[i - 1] < nums[i] && nums[i] < minNext[i + 1]) {
                    ans += 2;
                } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                    ans += 1;
                }
            }

            return ans;
        }

        //获取从0到i的最大值
        int[] maxFromStartToI(int[] nums) {
            int[] ans = new int[nums.length];
            ans[0] = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                ans[i] = Math.max(ans[i - 1], nums[i]);
            }
            return ans;
        }

        //获取从i到n-1的最小值
        int[] minFromIToEnd(int[] nums) {
            int[] ans = new int[nums.length];
            ans[nums.length - 1] = nums[nums.length - 1];
            for (int i = nums.length - 2; i >= 0; --i) {
                ans[i] = Math.min(ans[i + 1], nums[i]);
            }
            return ans;
        }
    }


}

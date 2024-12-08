package redo.p2300_2399;

import redo.testUtil.Arrs;

import java.util.Arrays;

public class P2389 {

    class Solution {
        public int[] answerQueries(int[] nums, int[] queries) {
            Arrays.sort(nums);
            for (int i = 1; i < nums.length; ++i) {
                nums[i] += nums[i - 1];
            }
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; ++i) {
                ans[i] = upperBound(nums, queries[i], 0, nums.length);
            }
            return ans;
        }

        public int upperBound(int[] nums, int target, int start, int end) {
            int low = start, high = end;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (nums[mid] <= target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new P2389().new Solution().answerQueries(Arrs.build("[4,5,2,1]"), Arrs.build("[3,10,21]"))));
    }

}

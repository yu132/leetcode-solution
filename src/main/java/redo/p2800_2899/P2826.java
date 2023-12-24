package redo.p2800_2899;

import redo.testUtil.Arrs;

import java.util.List;

public class P2826 {

    class Solution {
        public int minimumOperations(List<Integer> nums) {

            int count1 = 0, count2 = 0;

            int n = nums.size();

            for (int num : nums) {
                if (num == 1) {
                    ++count1;
                } else if (num == 2) {
                    ++count2;
                }
            }

            int count3 = n - count1 - count2;

            int ans = Integer.MAX_VALUE;
            int left2 = 0, left3 = 0;
            for (int i = 0; i < nums.size(); ++i) {
                int mid1 = 0, mid3 = 0;
                for (int j = i; j < nums.size(); ++j) {

                    int right = n - j;
                    int count = left2 + left3 + mid1 + mid3 + right - (count3 - left3 - mid3);
                    ans = Math.min(ans, count);

                    if (nums.get(j) == 1) {
                        ++mid1;
                    } else if (nums.get(j) == 3) {
                        ++mid3;
                    }
                }
                int right = 0;
                int count = left2 + left3 + mid1 + mid3 + right - (count3 - left3 - mid3);
                ans = Math.min(ans, count);
                if (nums.get(i) == 2) {
                    ++left2;
                } else if (nums.get(i) == 3) {
                    ++left3;
                }
            }
            int count = left2 + left3;
            ans = Math.min(ans, count);
            return ans;
        }
    }

    public static void main(String[] args) {
        int ans = new P2826().new Solution().minimumOperations(Arrs.buildL("[2,1,3,2,1]"));
        System.out.println(ans);
    }

}

package redo.p1900_1999;

import java.util.ArrayList;
import java.util.List;

public class P1906 {

    class Solution {
        public int[] minDifference(int[] nums, int[][] queries) {
            int n = nums.length;
            int[][] preCount = new int[n + 1][101];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j <= 100; ++j) {
                    preCount[i + 1][j] = preCount[i][j] + (nums[i] == j ? 1 : 0);
                }
            }
            int[] ans = new int[queries.length];
            for (int j = 0; j < queries.length; ++j) {
                int start = queries[j][0], end = queries[j][1];
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i <= 100; ++i) {
                    if (preCount[end + 1][i] - preCount[start][i] > 0) {
                        list.add(i);
                    }
                }
                int minAbs = Integer.MAX_VALUE;
                for (int i = 1; i < list.size(); ++i) {
                    minAbs = Math.min(minAbs, Math.abs(list.get(i) - list.get(i - 1)));
                }
                if (minAbs == Integer.MAX_VALUE) {
                    ans[j] = -1;
                } else {
                    ans[j] = minAbs;
                }
            }
            return ans;
        }
    }

}

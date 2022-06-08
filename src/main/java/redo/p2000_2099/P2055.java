package redo.p2000_2099;

import java.util.Arrays;

public class P2055 {

    class Solution {
        public int[] platesBetweenCandles(String s, int[][] queries) {
            int[] count1 = new int[s.length() + 1];
            int[] next1 = new int[s.length()], prev1 = new int[s.length()];
            Arrays.fill(next1, s.length());
            Arrays.fill(prev1, -1);
            for (int i = 0; i < s.length(); ++i) {
                count1[i + 1] += count1[i] + (s.charAt(i) == '|' ? 1 : 0);
                if (s.charAt(i) == '|') {
                    for (int x = i; x >= 0 && (x == i || s.charAt(x) != '|'); --x) {
                        next1[x] = i;
                    }
                }
            }
            for (int i = s.length() - 1; i >= 0; --i) {
                if (s.charAt(i) == '|') {
                    for (int x = i; x < s.length() && (x == i || s.charAt(x) != '|'); ++x) {
                        prev1[x] = i;
                    }
                }
            }
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; ++i) {
                int start = queries[i][0], end = queries[i][1];
                int start1 = next1[start], end1 = prev1[end];
                if (end1 < start1) {
                    ans[i] = 0;
                    continue;
                }
                int c1 = count1[end1 + 1] - count1[start1];
                ans[i] = end1 + 1 - start1 - c1;
            }
            return ans;
        }
    }

}

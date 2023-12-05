package redo.p2700_2799;

import redo.testUtil.Arrs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P2768 {

    class Solution {
        public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
            Set<Long> set = new HashSet<>();
            for (int[] loc : coordinates) {
                set.add(get(loc[0], loc[1]));
            }
            long[] ans = new long[5];
            for (int[] loc : coordinates) {
                int x = loc[0], y = loc[1];

                int xUyy = set.contains(get(loc[0] - 1, loc[1])) ? 1 : 0;
                int xDyy = set.contains(get(loc[0] + 1, loc[1])) ? 1 : 0;
                int xxyL = set.contains(get(loc[0], loc[1] - 1)) ? 1 : 0;
                int xxyR = set.contains(get(loc[0], loc[1] + 1)) ? 1 : 0;
                int xUyL = set.contains(get(loc[0] - 1, loc[1] - 1)) ? 1 : 0;
                int xUyR = set.contains(get(loc[0] - 1, loc[1] + 1)) ? 1 : 0;
                int xDyL = set.contains(get(loc[0] + 1, loc[1] - 1)) ? 1 : 0;
                int xDyR = set.contains(get(loc[0] + 1, loc[1] + 1)) ? 1 : 0;

                int UL = x > 0 && y > 0 ? xUyy + xxyL + xUyL + 1 : 0;
                int UR = x > 0 && y < n - 1 ? xUyy + xUyR + xxyR + 1 : 0;
                int DL = x < m - 1 && y > 0 ? xDyy + xxyL + xDyL + 1 : 0;
                int DR = x < m - 1 && y < n - 1 ? xDyy + xxyR + xDyR + 1 : 0;

                ++ans[UL];
                ++ans[UR];
                ++ans[DL];
                ++ans[DR];
            }

            ans[2] /= 2;
            ans[3] /= 3;
            ans[4] /= 4;

            ans[0] = (long) (m - 1) * (n - 1) - ans[1] - ans[2] - ans[3] - ans[4];

            return ans;
        }

        long get(int x, int y) {
            return x * 100001L + y;
        }
    }

    public static void main(String[] args) {
        long[] ans = new P2768().new Solution().countBlackBlocks(3, 3, Arrs.build2D("[[0,0],[1,1],[1,0],[0,1],[0,2]]"));
        System.out.println(Arrays.toString(ans));
    }

}

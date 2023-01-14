package redo.p0100_0199;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P132 {

    class Solution {
        public int minCut(String s) {
            List<Range> rs = new ArrayList<>();

            for (int i = 0; i < s.length(); ++i) {
                for (int l = i, h = l; l >= 0 && h < s.length(); --l, ++h) {
                    if (s.charAt(l) == s.charAt(h)) {
                        rs.add(new Range(l, h + 1));
                    } else {
                        break;
                    }
                }
                for (int l = i, h = l + 1; l >= 0 && h < s.length(); --l, ++h) {
                    if (s.charAt(l) == s.charAt(h)) {
                        rs.add(new Range(l, h + 1));
                    } else {
                        break;
                    }
                }
            }

            rs.sort(Comparator.comparingInt(Range::getX));

            int[] dp = new int[s.length() + 1];
            Arrays.fill(dp, 5000);
            dp[0] = 0;
            for (Range r : rs) {
                dp[r.y] = Math.min(dp[r.x] + 1, dp[r.y]);
            }
            return dp[s.length()] - 1;
        }

        class Range {
            int x, y;

            public int getX() {
                return x;
            }

            public Range(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }

}

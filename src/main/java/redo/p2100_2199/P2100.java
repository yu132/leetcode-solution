package redo.p2100_2199;

import java.util.ArrayList;
import java.util.List;

public class P2100 {

    class Solution {
        public List<Integer> goodDaysToRobBank(int[] security, int time) {

            List<Integer> ans = new ArrayList<>();

            if (time == 0) {
                for (int i = 0; i < security.length; ++i) {
                    ans.add(i);
                }
                return ans;
            }

            int n = security.length;

            boolean[] goodLeft = new boolean[n];

            int goDown = 0;

            for (int i = 1; i < n; ++i) {
                if (security[i] <= security[i - 1]) {
                    ++goDown;
                    if (goDown >= time) {
                        goodLeft[i] = true;
                    }
                } else {
                    goDown = 0;
                }
            }

            goDown = 0;

            for (int i = n - 2; i >= 0; --i) {
                if (security[i] <= security[i + 1]) {
                    ++goDown;
                    if (goDown >= time && goodLeft[i]) {
                        ans.add(i);
                    }
                } else {
                    goDown = 0;
                }
            }

            return ans;
        }
    }

}

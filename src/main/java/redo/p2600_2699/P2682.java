package redo.p2600_2699;

import java.util.ArrayList;
import java.util.List;

public class P2682 {

    class Solution {
        public int[] circularGameLosers(int n, int k) {
            int[] count = new int[n];
            int idx = 0;
            for (int i = 0; ; ++i, idx = (idx + i * k) % n) {
                if (++count[idx] == 2) {
                    break;
                }
            }
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                if (count[i] == 0) {
                    ans.add(i);
                }
            }
            return ans.stream().mapToInt(i -> i + 1).toArray();
        }
    }

}

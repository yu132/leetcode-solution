package redo.p2800_2899;

import java.util.ArrayList;
import java.util.List;

public class P2899 {

    class Solution {
        public List<Integer> lastVisitedIntegers(int[] nums) {
            List<Integer> seen = new ArrayList<>();
            List<Integer> ans = new ArrayList<>();
            int idx = 0;
            for (int num : nums) {
                if (num == -1) {
                    if (idx >= seen.size()) {
                        ans.add(-1);
                    } else {
                        ans.add(seen.get(seen.size() - 1 - idx));
                    }
                    ++idx;
                } else {
                    idx = 0;
                    seen.add(num);
                }
            }
            return ans;
        }
    }

}

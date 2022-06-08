package redo.p2100_2199;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P2178 {

    class Solution {
        public List<Long> maximumEvenSplit(long finalSum) {
            if (finalSum % 2 == 1) {
                return Collections.emptyList();
            }
            List<Long> ans = new ArrayList<>();
            for (long i = 2; finalSum >= i; i += 2) {
                ans.add(i);
                finalSum -= i;
            }
            if (finalSum != 0) {
                ans.set(ans.size() - 1, ans.get(ans.size() - 1) + finalSum);
            }
            return ans;
        }
    }

}

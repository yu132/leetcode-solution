package redo.p2800_2899;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P2895 {

    class Solution {
        public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
            Collections.sort(processorTime);
            tasks.sort(Comparator.reverseOrder());
            int ans = 0;
            for (int i = 0; i < tasks.size(); ++i) {
                ans = Math.max(ans, tasks.get(i) + processorTime.get(i / 4));
            }
            return ans;
        }
    }

}

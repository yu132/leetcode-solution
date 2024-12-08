package redo.p2800_2899;

import java.util.List;

public class P2865 {

    class Solution {
        public long maximumSumOfHeights(List<Integer> maxHeights) {
            long ans = 0;
            for (int i = 0; i < maxHeights.size(); ++i) {
                int nowMax = maxHeights.get(i);
                long sum = nowMax;
                for (int j = i - 1; j >= 0; --j) {
                    nowMax = Math.min(nowMax, maxHeights.get(j));
                    sum += nowMax;
                }
                nowMax = maxHeights.get(i);
                for (int j = i + 1; j < maxHeights.size(); ++j) {
                    nowMax = Math.min(nowMax, maxHeights.get(j));
                    sum += nowMax;
                }
                ans = Math.max(ans, sum);
            }
            return ans;
        }
    }

}

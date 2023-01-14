package redo.p1400_1499;

import java.util.Arrays;

public class P1402 {

    class Solution {
        public int maxSatisfaction(int[] satisfaction) {
            Arrays.sort(satisfaction);
            int index = 0;
            while (index < satisfaction.length && satisfaction[index] < 0) {
                ++index;
            }
            int sum = 0, ans = 0;
            for (int i = index; i < satisfaction.length; ++i) {
                sum += satisfaction[i];
                ans += (i - index + 1) * satisfaction[i];
            }
            for (int i = index - 1; i >= 0; --i) {
                if (sum <= -satisfaction[i]) {
                    break;
                }
                sum += satisfaction[i];
                ans += sum;
            }
            return ans;
        }
    }

}

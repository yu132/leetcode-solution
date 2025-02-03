package redo.p2800_2899;

import java.util.HashMap;

public class P2815 {

    class Solution {
        public int maxSum(int[] nums) {
            int ans = -1;
            HashMap<Integer, Integer> maxMap = new HashMap<>();
            for (int num : nums) {
                int maxDigit = maxDigit(num);
                if (maxMap.containsKey(maxDigit)) {
                    ans = Math.max(ans, maxMap.get(maxDigit) + num);
                }
                maxMap.put(maxDigit, Math.max(maxMap.getOrDefault(maxDigit, 0), num));
            }
            return ans;
        }

        int maxDigit(int num) {
            int max = 0;
            while (num > 0) {
                max = Math.max(max, num % 10);
                num /= 10;
            }
            return max;
        }
    }

}

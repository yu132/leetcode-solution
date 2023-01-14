package redo.p2500_2599;

import java.util.Arrays;
import java.util.HashMap;

public class P2501 {

    class Solution {
        public int longestSquareStreak(int[] nums) {
            Arrays.sort(nums);
            HashMap<Integer, Integer> extendMap = new HashMap<>();
            int max = 1;
            for (int num : nums) {
                int x = (int) Math.sqrt(num);
                if (x * x == num) {
                    int tmp = extendMap.getOrDefault(x, 0) + 1;
                    extendMap.put(num, tmp);
                    max = Math.max(max, tmp);
                } else {
                    extendMap.put(num, 1);
                }
            }
            if (max == 1) {
                return -1;
            } else {
                return max;
            }
        }
    }

}

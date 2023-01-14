package redo.zhousai;

import java.util.Arrays;
import java.util.function.Function;

public class P6096 {

    class Solution {
        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            Arrays.sort(potions);

            int[] ans = new int[spells.length];

            for (int i = 0; i < spells.length; ++i) {
                final int ii = i;
                ans[i] = potions.length - binarySearchMin(0, potions.length, mid -> (long) potions[mid] * spells[ii] >= success);
            }

            return ans;
        }

        public int binarySearchMin(int low, int high, Function<Integer, Boolean> judge) {
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (judge.apply(mid)) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }

}

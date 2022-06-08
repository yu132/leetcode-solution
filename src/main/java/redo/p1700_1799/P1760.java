package redo.p1700_1799;

import java.util.function.Function;

public class P1760 {

    class Solution {
        public int minimumSize(int[] nums, int maxOperations) {
            return binarySearchMin(1, (int) 10e9, mid -> {
                int count = 0;
                for (int num : nums) {
                    count += (num - 1) / mid;
                }
                return count <= maxOperations;
            });
        }

        // 寻找符合条件的最小值
        //judgeRange = [low,high-1], returnRange = [low,high]
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
